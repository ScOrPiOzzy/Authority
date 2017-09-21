package com.demo.test;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Administrator 使用以下命令生成keystore文件 alias:别名csdn keypass:别名密码 123456
 *         storepass:秘钥库的密码:888999 keytool -genkey -alias csdn -keypass 123456
 *         -keyalg RSA -keysize 1024 -validity 365 -keystore
 *         D:/csdn_server.keystore -storepass 888999
 */
public class TestKeyStore {
	public static void main(String[] args) throws Exception {
		// 读取keystore文件转换为keystore密钥库对象
		FileInputStream fis = new FileInputStream("D:/cas.keystore");
		// 因为生成证书的类型为JKS 也有其他的格式
		KeyStore keyStore = KeyStore.getInstance("JKS");
		// 该密钥库的密码"888999"
		String storepass = "cas123";
		keyStore.load(fis, storepass.toCharArray());
		fis.close();
		// 从keystore中读取证书和私钥
		String alias = "www.wxcas.com";// 别名
		String keypass = "cas123"; // 别名密码
		Certificate certificate = keyStore.getCertificate(alias);
		// 读取公钥对象
		PublicKey publicKey = certificate.getPublicKey();
		System.out.println("提取的公钥为___:\n" + Base64.encodeBase64String(publicKey.getEncoded()));
		// 读取私钥对象
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, keypass.toCharArray());
		System.out.println("提取的私钥为___:\n" + Base64.encodeBase64String(privateKey.getEncoded()));
	}
}
