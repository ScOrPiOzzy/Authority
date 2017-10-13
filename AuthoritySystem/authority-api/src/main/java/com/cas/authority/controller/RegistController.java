package com.cas.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cas.authority.Consts;
import com.cas.authority.util.KeyStoreUtil;
import com.cas.authority.util.RSAUtil;
import com.cas.authority.vo.AuthorityEntity;

@Controller
@RequestMapping(value = "authority")
public class RegistController extends AbstractBaseController {
	/**
	 * 生成证书
	 */
	@RequestMapping(path = "regist")
	public AuthorityEntity generateAuthorityFile(String regCode) {
		// 收到客户请求的注册码
//		String ciphertext = regCode;
//		System.err.println(ciphertext);
		try {
			regCode = RSAUtil.descryptByPrivateKey(KeyStoreUtil.getPrivateKey(getClass().getClassLoader().getResourceAsStream(Consts.FILE_KYESTORE), "www.wxcas.com", "cas123", "cas123"), regCode);
			System.out.println("收到客户注册码:" + regCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 开始验证注册码
		boolean valid = validate(regCode);

		AuthorityEntity entity = new AuthorityEntity();
		entity.setRegCode(regCode);
//		 客户端记录硬件信息
//		entity.setCpuSer("111");
//		entity.setHddSer("222");
		entity.setFromDate("2017-09-22");
		entity.setEndDate("2018-09-22");
		entity.setProductID("555");
		entity.setNode(5);

//		if (!avalid) {
//			return null;
//		}

		return entity;
	}

	private boolean validate(String registCode) {
		if (registCode == null) {
			return false;
		}
//		byte[] decrypt = null;
//		try {
//			decrypt = CertificateCoder.decryptByPrivateKey(registCode.getBytes("UTF-8"), keyStorePath, alias, password);
//			String outputStr = new String(decrypt);
//			System.out.println("解密后：" + outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return false;
	}
}
