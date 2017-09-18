package com.cas.lock;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * 用户客户端，用来测试资源
 * 
 * @author waylau.com 2014-3-18
 */
public class UserClient {

	private static String serverUri = "http://localhost:8080/AuthorityWebservice/rest/authority/1232222";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri);
		Response response = target.request().get();
		System.out.println(response.readEntity(String.class));
		response.close();
	}

	/**
	 * 添加用户
	 */
	private static void addUser() {
		System.out.println("****增加用户addUser****");
		// User user = new User("006","Susan","21");
		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target(serverUri + "/users");
		// Response response = target.request().buildPost(Entity.entity(user,
		// MediaType.APPLICATION_XML)).invoke();
		// response.close();
	}

	/**
	 * 删除用户
	 */
	private static void delUser() {
		System.out.println("****删除用户****");
		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target(serverUri + "/users/006");
		// Response response = target.request().delete();
		// response.close();
	}

	/**
	 * 修改用户
	 */
	private static void updateUser() {
		System.out.println("****修改用户updateUser****");
		// User user = new User("006","Susan","33");
		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target(serverUri + "/users");
		// Response response = target.request().buildPut( Entity.entity(user,
		// MediaType.APPLICATION_XML)).invoke();
		// response.close();
	}

	/**
	 * 根据id查询用户
	 */
	private static void getUserById() {
		System.out.println("****根据id查询用户****");
		// Client client =
		// ClientBuilder.newClient().register(JacksonJsonProvider.class);// 注册json 支持
		// WebTarget target = client.target(serverUri + "/users/006");
		// Response response = target.request().get();
		// User user = response.readEntity(User.class);
		// System.out.println(user.getUserId() + user.getUserName() + user.getAge());
		// response.close();
	}
}
