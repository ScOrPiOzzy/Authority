package com.cas.authority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.cas.authority.validate.ValidateThread;

public class AuthorityBootstrap {

	public static void main(String[] args) {
		AuthorityBootstrap authorityBootstrap = new AuthorityBootstrap();
		authorityBootstrap.validate();
//		Application.launch(RegistApplication.class);
	}

	public void validate() {
//		File file = new File("app.version");
//		Properties prop = new Properties();
//		try {
//			prop.load(new FileInputStream(file));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String productID = prop.getProperty("product_id", "no version");
//		if ("no version".equals(productID)) {
//			return;
//		}

		ValidateThread thread = new ValidateThread("2222");
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<Integer> task = pool.submit(thread);
		try {
			Integer result = task.get();

			pool.shutdown();

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
		System.err.println("错误代码:" + code);

//		启动注册程序
//		Application.launch(RegistApplication.class);
	}

	protected void success() {
		System.err.println("证书文件验证通过。可以启动程序");
	}
}
