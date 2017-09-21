package com.cas.lock;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cas.encrypt.KeyStoreUtil;
import com.cas.encrypt.RSAUtil;
import com.cas.lock.entiry.AuthorityEntity;

@Path("/authority")
public class AuthorityService {

	/**
	 * 生成证书
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("reg")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public AuthorityEntity generateAuthorityFile(@FormParam("regCode") String regCode) {
		// 收到客户请求的注册码
		// String ciphertext = regCode;
		// System.err.println(ciphertext);
		try {
			regCode = RSAUtil.descryptByPrivateKey(
					KeyStoreUtil.getPrivateKey("D:/cas.keystore", "www.wxcas.com", "cas123", "cas123"), regCode);
			System.out.println("收到客户注册码:" + regCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 开始验证注册码
		boolean avalid = validate(regCode);

		AuthorityEntity entity = new AuthorityEntity();
		entity.setRegCode(regCode);
		entity.setCpuSer("111");
		entity.setHddSer("222");
		entity.setFromDate("333");
		entity.setEndDate("4444");
		entity.setProductID("555");

		// if (!avalid) {
		// return null;
		// }

		return entity;
	}

	private boolean validate(String registCode) {
		if (registCode == null) {
			return false;
		}
		// byte[] decrypt = null;
		// try {
		// decrypt = CertificateCoder.decryptByPrivateKey(registCode.getBytes("UTF-8"),
		// keyStorePath, alias, password);
		// String outputStr = new String(decrypt);
		// System.out.println("解密后：" + outputStr);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		return false;
	}
}
