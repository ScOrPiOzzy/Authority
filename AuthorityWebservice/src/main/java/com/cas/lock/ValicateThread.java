package com.cas.lock;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.concurrent.Callable;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

/**
 * 验证证书的有效性
 * 
 * @author 张振宇
 *
 */
public class ValicateThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		File file = new File(Consts.AUTHORITY_FILE);
		// 判断授权文件是否存在
		if (!file.exists()) {
			return Consts.AUTHORITY_FILE_NOT_FOUNT;
		}
		// 验证授权文件的有效性
		FileInputStream fis = new FileInputStream(file);
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
		fis.close();
		// 检查授权文件MD5，判断是否被篡改。
		if (!"".equals(md5)) {
			return Consts.AUTHORITY_FILE_MODIFIED;
		}

		// 读取授权文件
		fis = new FileInputStream(file);

		fis.close();
		// 从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String hddSer = getHDDSer(systemInfo);
		// 从授权文件中获取硬盘信息
		String hddSerA = "";
		if (!hddSerA.equals(hddSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
		// 从本机获取CPU信息
		String cpuSer = getCPUSer(systemInfo);
		// 从授权文件中获取CPU信息
		String cpuSerA = "";
		if (!cpuSerA.equals(cpuSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
		// 获取本机时间
		Date d = new Date();
		// 读取授权周期
		Date dA = new Date();
		// 验证日期
		if (d.after(dA)) {
			return Consts.AUTHORITY_FILE_EXPIRED;
		}
		// 获取产品ID
		String productId = "";
		// 读取授权产品ID
		String productIdA = "";
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
