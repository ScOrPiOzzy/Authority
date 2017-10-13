package com.cas.authority.util;

import oshi.SystemInfo;
import oshi.software.os.OSFileStore;

public final class HardDriveUtil {
	private HardDriveUtil() {
	}

	public static String getPortitionId(SystemInfo systemInfo, char mount) {
		OSFileStore[] fileStore = systemInfo.getOperatingSystem().getFileSystem().getFileStores();
		String partitionID = null;
		for (int i = 0; i < fileStore.length; i++) {
			if (fileStore[i].getMount().charAt(0) == mount) {
				partitionID = fileStore[i].getUUID();
				break;
			}
		}
		if (partitionID == null) {
			throw new RuntimeException("您的系统中并没有发现" + mount + "盘");
		} else {
			System.out.println("找到" + mount + "盘， UUID为：" + partitionID);
		}
		return partitionID;
	}

	public static String getCPUSer(SystemInfo systemInfo) {
		return systemInfo.getHardware().getProcessor().getProcessorID();
	}
}
