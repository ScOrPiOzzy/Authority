package com.cas.encrypt;

import static org.junit.Assert.*;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.cas.lock.encrypt.AESUtil;
import com.cas.lock.encrypt.DESUtil;

public class EncriptTest {
	@Test
	public void testASE() throws Exception {
		String content = "test";
		String password = "12345678";
		// 加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = AESUtil.encrypt(content, password);
		System.out.println("加密后：" + Base64.encodeBase64String(encryptResult));

		// 解密
		byte[] decryptResult = AESUtil.decrypt(encryptResult, password);

		assertEquals(content, new String(decryptResult));
	}

	@Test
	public void testDES() throws Exception {
		String source = "amigoxie";
		System.out.println("原文: " + source);
		String key = "A1B2C3D4E5F60708";
		String encryptData = DESUtil.encrypt(source, key);
		System.out.println("加密后: " + encryptData);
		String decryptData = DESUtil.decrypt(encryptData, key);
		System.out.println("解密后: " + decryptData);

		assertEquals(source, new String(decryptData));
	}
}
