package com.cas.test;

import com.cas.authority.util.HardDriveUtil;

import oshi.SystemInfo;

public class OsgiTest {
	public static void main(String[] args) {
		// 从本机获取硬盘信息
		SystemInfo systemInfo = new SystemInfo();
		String relativelyPath = System.getProperty("user.dir");
		String partitionID = HardDriveUtil.getPortitionId(systemInfo, relativelyPath.charAt(0));
		System.out.println(partitionID);
	}
}
