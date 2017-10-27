package com.cas.test;

import java.util.UUID;

import org.junit.Test;

import com.cas.authority.action.RegisterAction;
import com.cas.authority.util.HardDriveUtil;

import oshi.SystemInfo;

public class OsgiTest {
	public static void main(String[] args) {
		// 从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String relativelyPath = System.getProperty("user.dir");
		System.out.println(HardDriveUtil.getPortitionId(systemInfo, relativelyPath.charAt(0)));
		System.out.println(HardDriveUtil.getCPUSer(systemInfo));

		new RegisterAction() {
			protected String getProductID() {
				return "1";
			};

			@Override
			protected String getRegistCode() {
				return "000";
			}

			protected String getUserName() {
				return "111";
			}

			@Override
			protected boolean reRegistration() {
				return true;
			}

			protected void onRegistResult(boolean success) {
			}
		}.execute();

	}

	@Test
	public void testUUID() throws Exception {
		System.out.println(UUID.fromString("56d16a78-0b58-416b-bb73-82b030f92df1"));
	}
}
