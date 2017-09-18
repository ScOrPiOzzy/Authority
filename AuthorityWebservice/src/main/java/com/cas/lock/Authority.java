package com.cas.lock;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sun.net.www.protocol.https.Handler;

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

	public static void main(String[] args) throws Exception {
		String addr = "http://localhost:8080/AuthorityWebservice/rest/authority/1232222";
		URL url = new URL(null, addr, new Handler());
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		InputStream is = conn.getInputStream();
		System.out.println(is);

		int length = conn.getContentLength();

		DataInputStream dis = new DataInputStream(is);
		byte[] data = new byte[length];
		dis.readFully(data);

		dis.close();
		conn.disconnect();
		System.err.println(new String(data));
	}

	/**
	 * 生成证书
	 */
	@GET
	@Path("/{param}")
	@Produces("text/plain;charset=UTF-8")
	public String generateAuthorityFile(@PathParam("param") String registCode) {

		// 验证注册码
		boolean avalid = validate(registCode);

		if (avalid) {
			return "";
		}
		return registCode;
	}

	private boolean validate(String registCode) {
		// TODO Auto-generated method stub
		return false;
	}
}
