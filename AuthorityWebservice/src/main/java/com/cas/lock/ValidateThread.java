package com.cas.lock;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.Callable;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.cas.lock.entiry.AuthorityEntity;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

/**
 * 验证证书的有效性
 * 
 * @author 张振宇
 *
 */
public class ValidateThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		File authorityFile = new File(Consts.AUTHORITY_FILE);
		// 判断授权文件是否存在
		if (!authorityFile.exists()) {
			return Consts.AUTHORITY_FILE_NOT_FOUNT;
		}
		// 验证授权文件的有效性
		FileInputStream fis = new FileInputStream(authorityFile);
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
		fis.close();
		// 检查授权文件MD5，判断是否被篡改。
		File receiptFile = new File(Consts.RECEIPT_FILE);
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(new FileInputStream(receiptFile))))) {

			// 第一行非空行的数据是授权文件的MD5校验值
			String recordedMD5 = null;
			while ((recordedMD5 = br.readLine()) != null) {
				recordedMD5 = recordedMD5.trim();
				if (!"".equals(recordedMD5)) {
					break;
				}
			}
			// 如果文件MD5码与记录的值不一样，说明文件被修改过。
			if (!recordedMD5.equals(md5)) {
				return Consts.AUTHORITY_FILE_MODIFIED;
			}
		}

		AuthorityEntity entity = EntityUtil.parseEntity(authorityFile);
		// 验证文件的数字签名
		String sign = DigestUtils.sha256Hex(entity.toString());
		if (!sign.equals(entity.getSign())) {
			// 签名不符, 文件被修改过
			return Consts.AUTHORITY_FILE_MODIFIED;
		}
		// 从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String hddSer = getHDDSer(systemInfo);
		// 从授权文件中获取硬盘信息
		String hddSerA = entity.getHddSer();
		if (!hddSerA.equals(hddSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
		// 从本机获取CPU信息
		String cpuSer = getCPUSer(systemInfo);
		// 从授权文件中获取CPU信息
		String cpuSerA = entity.getCpuSer();
		if (!cpuSerA.equals(cpuSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
//		// 获取本机时间
//		Date d = new Date();
//		// 读取授权周期
//		Date dA = new Date();
//		// 验证日期
//		if (d.after(dA)) {
//			return Consts.AUTHORITY_FILE_EXPIRED;
//		}
		// 获取产品ID
		String productId = "";
		// 读取授权产品ID
		String productIdA = entity.getProductID();
		// 验证产品ID
		if (productIdA.equals(productId)) {
			return Consts.AUTHORITY_FILE_UNPITCH;
		}
		return Consts.AUTHORITY_FILE_AVAILABLE;
	}

	private String getHDDSer(SystemInfo systemInfo) {
		HWDiskStore[] diskStores = systemInfo.getHardware().getDiskStores();
		String result = null;

		for (int i = 0; i < diskStores.length; i++) {
			HWPartition[] partitions = diskStores[i].getPartitions();
			for (int j = 0; j < partitions.length; j++) {
				char p = partitions[j].getMountPoint().charAt(0);
				if ('C' == p) {
					result = diskStores[i].getSerial();
					break;
				}
			}
		}
		return result;
	}

	private String getCPUSer(SystemInfo systemInfo) {
		return systemInfo.getHardware().getProcessor().getProcessorID();
	}

}
