package com.cas.lock;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

public final class HardDriveUtil {
	private HardDriveUtil() {
	}

	public static String getHDDSer(SystemInfo systemInfo) {
		HWDiskStore[] diskStores = systemInfo.getHardware().getDiskStores();
		String result = null;

		for (int i = 0; i < diskStores.length; i++) {
			HWPartition[] partitions = diskStores[i].getPartitions();
			for (int j = 0; j < partitions.length; j++) {
				char p = partitions[j].getMountPoint().charAt(0);
				if ('C' == p) {
					result = diskStores[i].getSerial();
					break;
				}
			}
		}
		return result;
	}

	public static String getCPUSer(SystemInfo systemInfo) {
		return systemInfo.getHardware().getProcessor().getProcessorID();
	}
}
