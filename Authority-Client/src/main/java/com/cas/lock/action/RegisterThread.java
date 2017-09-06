package com.cas.lock.action;

import java.util.concurrent.Callable;

/**
 * 用户注册
 * 
 * @author Administrator
 *
 */
public class RegisterThread implements Callable<Void> {

	private String regCode;

	public RegisterThread(String regCode) {
		this.regCode = regCode;
	}

	@Override
	public Void call() throws Exception {
		
		return null;
	}

}
