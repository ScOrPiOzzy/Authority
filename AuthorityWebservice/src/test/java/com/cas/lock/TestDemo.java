package com.cas.lock;

import com.cas.encrypt.KeyStoreUtil;
import com.cas.encrypt.RSAUtil;

public class TestDemo {

	public static void main(String[] args) {
		// 公钥
		// byte[] strPublicKey = null;
		// 私钥
		byte[] strPrivateKey = null;

		try {
			// strPublicKey = KeyStoreCoder.getPublicKey("D:\\cas.keystore",
			// "www.wxcas.com", "cas123").getEncoded();
			// System.out.println("公钥 = 【" + strPublicKey + "】");

			strPrivateKey = KeyStoreUtil.getPrivateKey("D:\\cas.keystore", "www.wxcas.com", "cas123", "cas123")
					.getEncoded();
			System.out.println("\n私钥 = 【" + strPrivateKey + "】");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 原文
		String originalText = "2017-09-20";

		try {
			// RSA算法 公钥加密随机数
			String secretText = RSAUtil.encryptByPublicKey(
					KeyStoreUtil.getPublicKey("D:\\cas.keystore", "www.wxcas.com", "cas123"), originalText);
			System.out.println("\n经RSA公钥加密后 = " + secretText);
			System.out.println("\n经RSA公钥加密后长度 = " + secretText.length());

			String text = RSAUtil.descryptByPrivateKey(
					KeyStoreUtil.getPrivateKey("D:\\cas.keystore", "www.wxcas.com", "cas123", "cas123"), secretText);
			System.out.println("\n经RSA私钥解密后 = 【" + text + "】");
			System.out.println("\n经RSA私钥解密后长度 = 【" + text.length() + "】");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
