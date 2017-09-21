package com.demo.test;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.apache.commons.codec.binary.Base64;

import com.cas.encrypt.KeyStoreUtil;

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

		String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAonlrDPO0urPt/iRdz7h/4mzNhonNHbKReZDt+EBe6+ytzkKQ69ECqia5I1vY0VpVRXik2SorbKneyY70JBCarlkNPOupNpxsEVDE7mp2AW3V+tdGyxS+Iel3KwtCpd5o38/VrS8ODZoRLcOyKFhMcND86opnnhV8TUg3yDDlaUAtTDlOCdRI6GyBC5Q2L4Z9T1LpGjkc/QLWTqFDZZZkE6mgjr1iZWRbXgyA1I5CyC8A5K6VJhL0RrFb4PdLGZ+s9BHSbfO+WSgu6bSDMWeaZ/Y7YoHd99D5S18Yc4WTa+dfG5yXbHPcLZivGGMap1PepiAkjtEkfGomEhSdi5WUAQIDAQAB";
		PublicKey pubkey = KeyStoreUtil.getPublicKey(key);

		System.out.println(publicKey.equals(pubkey));
		// 读取私钥对象
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, keypass.toCharArray());
		System.out.println("提取的私钥为___:\n" + Base64.encodeBase64String(privateKey.getEncoded()));
	}
}
