package com.cas.authority.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.cas.authority.Consts;
import com.cas.authority.model.AuthorityEntity;
import com.cas.authority.util.EntityUtil;
import com.cas.authority.util.HardDriveUtil;
import com.cas.authority.util.KeyStoreUtil;

import oshi.SystemInfo;

/**
 * 用户注册
 * @author Administrator
 */
public class RegisterAction {

	public void execute() {
//		1、准备创建证书
		File authorityFile = new File(Consts.FILE_AUTHORITY);
		if (authorityFile.exists()) {
//			如果不用重新注册，则返回
			if (!reRegistration()) {
				return;
			}
//			重新注册
		}

		// 2、提供注册码
		String registCode = getRegistCode();
		if (registCode == null || "".equals(registCode)) {
			return;
		}
		// 2、提供注册码
		String username = getUserName();
		if (username == null || "".equals(username)) {
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
		WebTarget target = client.target(Consts.BASE_SERVER_URI + Consts.SERVER_URI_REG);
		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();

//		用户名称
		formData.add("customName", username);
//		产品ID
		formData.add("productID", registCode);
//		用户注册码
		formData.add("code", registCode);
//		用户电脑信息
		formData.add("hddSer", username);
		formData.add("cpuSer", registCode);

		Response response = target.request().post(Entity.form(formData));

		AuthorityEntity entity = response.readEntity(AuthorityEntity.class);
		// 4、取得服务器的验证信息
		if (entity == null) {
			// 提示用户注册失败。
			onRegistResult(false);
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
			onRegistResult(true);
		}
	}

	protected String getUserName() {
		return "test_user";
	}

	protected String getRegistCode() {
		return "123456789ABCDEFG";
	}

	protected void onRegistResult(boolean success) {

	}

	/**
	 * hook method。当授权文件已经存在时，子类需要具体处理这个情况。<br>
	 * @return ture：重新注册，false：取消注册,默认是取消注册
	 */
	protected boolean reRegistration() {
		return false;
	}
}
