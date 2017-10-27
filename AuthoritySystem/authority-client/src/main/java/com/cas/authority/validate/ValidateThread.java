package com.cas.authority.validate;

import java.io.InputStream;
import java.util.concurrent.Callable;

import org.apache.commons.codec.digest.DigestUtils;

import com.cas.authority.Consts;
import com.cas.authority.model.AuthorityEntity;
import com.cas.authority.util.EntityUtil;
import com.cas.authority.util.HardDriveUtil;

import oshi.SystemInfo;

/**
 * 验证证书的有效性
 * @author 张振宇
 */
public class ValidateThread implements Callable<Integer> {

	private String productID;

	private AuthorityEntity entity;

	public ValidateThread(String productID) {
		this.productID = productID;
	}

	@Override
	public Integer call() throws Exception {
		InputStream ins = getClass().getClassLoader().getResourceAsStream(Consts.FILE_AUTHORITY);

//		判断授权文件是否存在
		if (ins == null) {
			return Consts.AUTHORITY_FILE_NOT_FOUNT;
		}
////		验证授权文件的有效性
//		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(ins));
////		检查授权文件MD5，判断是否被篡改。
//		File receiptFile = new File(Consts.FILE_RECEIPT);
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(receiptFile))))) {
//
////			第一行非空行的数据是授权文件的MD5校验值
//			String recordedMD5 = null;
//			while ((recordedMD5 = br.readLine()) != null) {
//				recordedMD5 = recordedMD5.trim();
//				if (!"".equals(recordedMD5)) {
//					break;
//				}
//			}
//			// 如果文件MD5码与记录的值不一样，说明文件被修改过。
//			if (!recordedMD5.equals(md5)) {
//				return Consts.AUTHORITY_FILE_MODIFIED;
//			}
//		}

		entity = EntityUtil.parseEntity(ins);
		// 验证文件的数字签名
		String sign = DigestUtils.sha256Hex(entity.toString());
		if (!sign.equals(entity.getSign())) {
			// 签名不符, 文件被修改过
			return Consts.AUTHORITY_FILE_MODIFIED;
		}
		// 从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String relativelyPath = System.getProperty("user.dir");
		String hddSer = HardDriveUtil.getPortitionId(systemInfo, relativelyPath.charAt(0));
		if (hddSer == null) {
			throw new RuntimeException("读取信息失败！");
		}
		// 从授权文件中获取硬盘信息
		String hddSerA = entity.getHddSer();
		if (!hddSerA.equals(hddSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
		// 从本机获取CPU信息
		String cpuSer = HardDriveUtil.getCPUSer(systemInfo);
		// 从授权文件中获取CPU信息
		String cpuSerA = entity.getCpuSer();
		if (!cpuSerA.equals(cpuSer)) {
			return Consts.AUTHORITY_FILE_COPY;
		}
		// 获取产品ID
		// 读取授权产品ID
		String productIdA = entity.getProductID();
		// 验证产品ID
		if (!productIdA.equals(productID)) {
			return Consts.AUTHORITY_FILE_UNPITCH;
		}
		return Consts.AUTHORITY_FILE_AVAILABLE;
	}

	public AuthorityEntity getEntity() {
		return entity;
	}
}
