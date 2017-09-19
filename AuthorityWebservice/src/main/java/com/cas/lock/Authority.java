package com.cas.lock;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authority")
public class Authority {

	private String password = "cas123";
	private String alias = "www.wxcas.com";
	private String certificatePath = "d:/cas.cer";
	private String keyStorePath = "d:/cas.keystore";

	public void test() {
		System.err.println("公钥加密——私钥解密");
		String inputStr = "Ceritifcate";
		byte[] data = inputStr.getBytes();

		byte[] encrypt = null;
		try {
			encrypt = CertificateCoder.encryptByPublicKey(data, certificatePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		byte[] decrypt = null;
		try {
			decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String outputStr = new String(decrypt);

		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

		// // 验证数据一致
		// assertArrayEquals(data, decrypt);
		//
		// // 验证证书有效
		// assertTrue(CertificateCoder.verifyCertificate(certificatePath));

	}

	public void testSign() throws Exception {
		System.err.println("私钥加密——公钥解密");

		String inputStr = "sign";
		byte[] data = inputStr.getBytes();

		byte[] encodedData = CertificateCoder.encryptByPrivateKey(data, keyStorePath, alias, password);

		byte[] decodedData = CertificateCoder.decryptByPublicKey(encodedData, certificatePath);

		String outputStr = new String(decodedData);
		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
		// assertEquals(inputStr, outputStr);

		System.err.println("私钥签名——公钥验证签名");
		// 产生签名
		String sign = CertificateCoder.sign(encodedData, keyStorePath, alias, password);
		System.err.println("签名:\r" + sign);

		// 验证签名
		boolean status = CertificateCoder.verify(encodedData, sign, certificatePath);
		System.err.println("状态:\r" + status);
		// assertTrue(status);

	}

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
