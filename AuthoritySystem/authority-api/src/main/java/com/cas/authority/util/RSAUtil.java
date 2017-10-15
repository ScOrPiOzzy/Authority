package com.cas.authority.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public final class RSAUtil {
	public static final String ALGORITHM = "RSA";

	private RSAUtil() {
	}

	public static PublicKey getPublicKey(String publicKey) throws Exception {
		// 解密
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
		KeyFactory kf = KeyFactory.getInstance(ALGORITHM);
		// 获取公钥
		return kf.generatePublic(spec);
	}

	/**
	 * 使用公钥加密数据
	 * @param publicKey
	 * @param srcData
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(Key pubKey, String srcData) throws Exception {
		// 对数据加密
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] doFinal = cipher.doFinal(srcData.getBytes());
		return Base64.encodeBase64String(doFinal);
	}

	/**
	 * 使用私钥解密数据
	 * @param privateKey
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String descryptByPrivateKey(Key privateKey, String data) throws Exception {
		// // BASE64转码
		byte[] text = Base64.decodeBase64(data);
		// PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
		// KeyFactory kf = KeyFactory.getInstance("RSA");
		// // 获取私钥
		// PrivateKey prvKey = kf.generatePrivate(spec);

		// 对数据加密
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		byte[] doFinal = cipher.doFinal(text);
		return new String(doFinal);
	}
}
