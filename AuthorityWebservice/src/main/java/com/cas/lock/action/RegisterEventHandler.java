package com.cas.lock.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.cas.lock.Consts;
import com.cas.lock.EntityUtil;
import com.cas.lock.HardDriveUtil;
import com.cas.lock.encrypt.KeyStoreUtil;
import com.cas.lock.encrypt.RSAUtil;
import com.cas.lock.entiry.AuthorityEntity;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import oshi.SystemInfo;

/**
 * 用户注册
 * @author Administrator
 */
public class RegisterEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		// 1、准备创建证书
		File authorityFile = new File(Consts.FILE_AUTHORITY);
		if (authorityFile.exists()) {
			// 似乎已经注册了，询问用户是否要重新注册
			// 如果选择否
			boolean overlay = true;

			if (!overlay) {
				return;
			}
		}

		// 2、提供注册码
		String regCode = "123456789ABCDEFG";
		regCode = JOptionPane.showInputDialog("请输入注册码：", regCode);
		if (regCode == null || "".equals(regCode)) {
			// 没有输入注册码
			return;
		}

		PublicKey pubKey = null;
		try {
			pubKey = KeyStoreUtil.getPublicKey(Consts.FILE_CERTIFICATION);
		} catch (Exception e) {
			//
			throw new RuntimeException("无效的证书文件");
		}

		// 3、将注册码发送给公司服务器
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI + "reg");
		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
		formData.add("regCode", RSAUtil.encryptByPublicKey(pubKey, regCode));
		Response response = target.request().post(Entity.form(formData));
		AuthorityEntity entity = response.readEntity(AuthorityEntity.class);
		// 4、取得服务器的验证信息
		if (entity == null) {
			// 提示用户注册失败。
		} else {
			// 用户收到的证书信息：
			System.out.println("用户收到的证书信息：" + entity);

			// 记录硬件信息
			SystemInfo info = new SystemInfo();
			// 从本机获取硬盘信息
			SystemInfo systemInfo = new SystemInfo();
			String relativelyPath = System.getProperty("user.dir");
			String partitionID = HardDriveUtil.getPortitionId(systemInfo, relativelyPath.charAt(0));
			entity.setHddSer(partitionID);
			entity.setCpuSer(HardDriveUtil.getCPUSer(info));

			EntityUtil.saveEntity(entity, authorityFile);

			// 4-2、保存收据receipt
			File receipt = new File(Consts.FILE_RECEIPT);
			try (PrintWriter out = new PrintWriter(new FileOutputStream(receipt));) {
				// 1、保存授权文件MD5校验码
				String authorityFileMD5 = DigestUtils.md5Hex(IOUtils.toByteArray(new FileInputStream(authorityFile)));
				System.out.println("authorityFile MD5 : " + authorityFileMD5);
				out.println(authorityFileMD5);
			} catch (IOException e) {
				throw new RuntimeException("");
			}
		}
	}

	public static void main(String[] args) {
		try {
			new RegisterEventHandler().handle(null);
		} catch (Exception e) {
			System.err.println("注册失败：" + e.getMessage());
			e.printStackTrace();
		}
	}

}
