package com.cas.lock;

import java.io.File;
import java.util.concurrent.Callable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

/**
 * 客户端注册 27458
 * 
 * @author 张振宇
 */
public class UserClient implements Callable<Integer> {
	// 客户端授权证书
	public static final String AUTHORITY_FILE = "/cas.authority";

	public static String password = "cas123";
	public static String alias = "www.wxcas.com";
	public static String certificatePath = "d:/cas.cer";
	public static String keyStorePath = "d:/cas.keystore";

	@Override
	public Integer call() throws Exception {

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI);

		MultivaluedHashMap<String, String> formData = new MultivaluedHashMap<String, String>();
		// formData.add("regCode", regCode);
		Response response = target.request().post(Entity.form(formData));
		System.out.println(response.readEntity(String.class));
		response.close();
	}

	public void regist() {
		File authorityFile = new File(AUTHORITY_FILE);
		if (authorityFile.exists()) {

		}
	}

	// 本地验证
	public void validate() {

	}

}
