package com.cas.lock;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authority")
public class AuthorityService {

	/**
	 * 生成证书
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("reg")
	@Produces("text/plain;charset=UTF-8")
	public String generateAuthorityFile(@FormParam("regCode") String regCode) {

		System.out.println("收到客户注册码:" + regCode);
		// 验证注册码
		boolean avalid = validate(regCode);

		if (!avalid) {
			return "invalid";
		}

		return regCode;
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
