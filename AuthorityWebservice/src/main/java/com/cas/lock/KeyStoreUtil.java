package com.cas.lock;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class KeyStoreUtil {

	/**
	 * Java密钥库(Java Key Store，JKS)KEY_STORE
	 */
	public static final String KEY_STORE = "JKS";

	public static final String X509 = "X.509";

	/**
	 * 获得KeyStore
	 * 
	 * @version 2012-3-16
	 * @param keyStorePath
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {

		FileInputStream is = new FileInputStream(keyStorePath);
		KeyStore ks = KeyStore.getInstance(KEY_STORE);
		ks.load(is, password.toCharArray());
		is.close();
		return ks;
	}

	/**
	 * 由KeyStore获得私钥
	 * 
	 * @param keyStorePath
	 * @param alias
	 * @param storePass
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String keyStorePath, String alias, String storePass, String keyPass)
			throws Exception {
		KeyStore ks = getKeyStore(keyStorePath, storePass);
		PrivateKey key = (PrivateKey) ks.getKey(alias, keyPass.toCharArray());
		return key;
	}

	/**
	 * 由Certificate获得公钥
	 * 
	 * @param keyStorePath
	 *            KeyStore路径
	 * @param alias
	 *            别名
	 * @param storePass
	 *            KeyStore访问密码
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String keyStorePath, String alias, String storePass) throws Exception {
		KeyStore ks = getKeyStore(keyStorePath, storePass);
		PublicKey key = ks.getCertificate(alias).getPublicKey();
		return key;
	}

	/**
	 * 从KeyStore中获取公钥，并经BASE64编码
	 * 
	 * @param keyStorePath
	 * @param alias
	 * @param storePass
	 * @return
	 * @throws Exception
	 */
	public static String getStrPublicKey(String keyStorePath, String alias, String storePass) throws Exception {
		PublicKey key = getPublicKey(keyStorePath, alias, storePass);
		return Base64.encodeBase64String(key.getEncoded());
	}

	/**
	 * 获取经BASE64编码后的私钥
	 * 
	 * @param keyStorePath
	 * @param alias
	 * @param storePass
	 * @param keyPass
	 * @return
	 * @throws Exception
	 */
	public static String getStrPrivateKey(String keyStorePath, String alias, String storePass, String keyPass)
			throws Exception {

		PrivateKey key = getPrivateKey(keyStorePath, alias, storePass, keyPass);
		return Base64.encodeBase64String(key.getEncoded());
	}

	/**
	 * 使用公钥加密数据
	 * 
	 * @param publicKey
	 * @param srcData
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(Key pubKey, String srcData) throws Exception {
		// // 解密
		// X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
		// KeyFactory kf = KeyFactory.getInstance("RSA");
		// // 获取公钥
		// PublicKey pubKey = kf.generatePublic(spec);
		//
		// 对数据加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);

		byte[] doFinal = cipher.doFinal(srcData.getBytes());
		return Base64.encodeBase64String(doFinal);
	}

	/**
	 * 使用私钥解密数据
	 * 
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
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		byte[] doFinal = cipher.doFinal(text);
		return new String(doFinal);
	}
}
