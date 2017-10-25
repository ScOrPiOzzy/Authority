package com.cas.authority.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cas.authority.Consts;
import com.cas.authority.model.AuthorityEntity;
import com.cas.authority.util.EntityUtil;
import com.cas.authority.util.HardDriveUtil;

import oshi.SystemInfo;
import oshi.util.platform.windows.WmiUtil;

/**
 * 用户注册
 * @author Administrator
 */
public class RegisterAction {
    private static final Logger LOG = LoggerFactory.getLogger(WmiUtil.class);

	public void execute() {
////		1、准备创建证书
//		File authorityFile = new File(Consts.FILE_AUTHORITY);
//		if (authorityFile.exists()) {
////			如果不用重新注册，则返回
//			if (!reRegistration()) {
//				return;
//			}
////			重新注册
//		}

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

//		PublicKey pubKey = null;
//		try {
//			pubKey = KeyStoreUtil.getPublicKey(Consts.FILE_CERTIFICATION);
//		} catch (Exception e) {
//			//
//			throw new RuntimeException("无效的证书文件");
//		}

		// 3、将注册码发送给公司服务器
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI + Consts.SERVER_URI_REG);
		System.out.println(target.getUri());
        LOG.info(target.getUri().toString());

		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();

//		用户名称
		formData.add("customName", username);
//		产品ID
		formData.add("productID", getProductID());
//		用户注册码
		formData.add("code", registCode);
//		用户电脑信息
//		从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String relativelyPath = System.getProperty("user.dir");
		formData.add("hddSer", HardDriveUtil.getPortitionId(systemInfo, relativelyPath.charAt(0)));
		formData.add("cpuSer", HardDriveUtil.getCPUSer(systemInfo));

		Response response = target.request().post(Entity.form(formData));

		AuthorityEntity entity = response.readEntity(AuthorityEntity.class);
		// 4、取得服务器的验证信息
		if (entity == null) {
			// 提示用户注册失败。
			onRegistResult(false);
		} else {
			// 4-1、 用户收到的证书信息：
			System.out.println("用户收到的证书信息：" + entity);
			try {
//				定义一个jaroutputstream流
				String basePath = System.getProperty("user.dir") + "\\lib\\";
				File file = new File(basePath);
				if (!file.exists()) {
					file.mkdirs();
				}

				JarOutputStream stream = new JarOutputStream(new FileOutputStream(basePath + "\\license.jar"));
				JarEntry entry = new JarEntry(Consts.FILE_AUTHORITY);
//				表示将该entry写入jar文件中 也就是创建该文件
				stream.putNextEntry(entry);
				EntityUtil.saveEntity(entity, stream);
				stream.closeEntry();
				stream.close();
				onRegistResult(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			// 4-2、保存收据receipt
//			entry = new JarEntry(Consts.FILE_RECEIPT);
////			表示将该entry写入jar文件中 也就是创建该文件
//			stream.putNextEntry(entry);
//			
//			try (PrintWriter out = new PrintWriter(new FileOutputStream(receipt));) {
//				// 1、保存授权文件MD5校验码
//				String authorityFileMD5 = DigestUtils.md5Hex(IOUtils.toByteArray(new FileInputStream(authorityFile)));
//				System.out.println("authorityFile MD5 : " + authorityFileMD5);
//				out.println(authorityFileMD5);
//			} catch (IOException e) {
//				throw new RuntimeException("");
//			}
		}
	}

	protected String getProductID() {
		return "-1";
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
