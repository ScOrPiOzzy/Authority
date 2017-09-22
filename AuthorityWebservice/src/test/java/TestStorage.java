import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

public class TestStorage {
	public static void main(String[] args) {
		SystemInfo systemInfo = new SystemInfo();
		HWDiskStore[] diskStores = systemInfo.getHardware().getDiskStores();

		for (int i = 0; i < diskStores.length; i++) {
			HWPartition[] partitions = diskStores[i].getPartitions();
			for (int j = 0; j < partitions.length; j++) {
				System.out.println(diskStores[i].getName() +" --> "+partitions[j].getMountPoint());
			}
		}
	}
}
