package com.cas.authority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.cas.authority.javafx.RegistApplication;
import com.cas.authority.validate.ValidateThread;


import javafx.application.Application;
public class AuthorityBootstrap {

	public static void main(String[] args) {
//		AuthorityBootstrap authorityBootstrap = new AuthorityBootstrap();
//		authorityBootstrap.validate();
		Application.launch(RegistApplication.class);
	}

	public void validate() {
		String productID = "2";
		ValidateThread thread = new ValidateThread(productID);
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<Integer> task = pool.submit(thread);
		try {
			Integer result = task.get();
			if (result != Consts.AUTHORITY_FILE_AVAILABLE) {
				failure(result);
			} else {
				success();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	protected void failure(Integer code) {
		System.err.println("无效的证书文件。 错误代码:" + code);

//		启动注册程序
//		Application.lunch(RegistApplication.class);
	}

	protected void success() {
		System.err.println("证书文件验证通过。可以启动程序");
	}
}
