package com.cas.lock.action;

import javax.swing.text.StyleConstants.ColorConstants;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import com.cas.lock.Consts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 用户注册
 * 
 * @author Administrator
 *
 */
public class RegisterEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		String regCode = "";
		if (regCode == null || "".equals(regCode)) {
			// 没有输入注册码
			return;
		}

		// 将注册码发送给公司服务器
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI + "reg");

		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
		formData.add("regCode", regCode);
		Object status = target.request().post(Entity.form(formData)).getEntity();
		System.out.println("RegisterEventHandler.handle()" + status);
	}

	public static void main(String[] args) {
		// 将注册码发送给公司服务器
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI + "reg");

		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
		formData.add("regCode", "12356");
		String status = target.request().post(Entity.form(formData)).readEntity(String.class);

		System.out.println("RegisterEventHandler.handle()" + status);
	}

}
