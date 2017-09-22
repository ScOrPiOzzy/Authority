package com.demo.test;

import java.util.Date;

import org.junit.Test;

import com.cas.lock.TimerClock;

public class FileTest {
	@Test
	public void testFile() throws Exception {
		new TimerClock(new Date(System.currentTimeMillis() - 10000),
				new Date(System.currentTimeMillis() + 1000)).run();
	}

}
