package com.cas.lock;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cas.lock.encrypt.KeyStoreUtil;
import com.cas.lock.encrypt.RSAUtil;
import com.cas.lock.entiry.AuthorityEntity;

@Path("/authority")
public class AuthorityService {

	/**
	 * 生成证书
	 */
	@GET
	@Path("time")
	public Long getServerTime() {
		return System.currentTimeMillis();
	}

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
			regCode = RSAUtil.descryptByPrivateKey(KeyStoreUtil.getPrivateKey(AuthorityService.class.getResourceAsStream(Consts.FILE_KYESTORE), "www.wxcas.com", "cas123", "cas123"), regCode);
			System.out.println("收到客户注册码:" + regCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 开始验证注册码
		boolean valid = validate(regCode);

		AuthorityEntity entity = new AuthorityEntity();
		entity.setRegCode(regCode);
		// 客户端记录硬件信息
		// entity.setCpuSer("111");
		// entity.setHddSer("222");
		entity.setFromDate("2017-09-22");
		entity.setEndDate("2018-09-22");
		entity.setProductID("555");
		entity.setNode(5);

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
