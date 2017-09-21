package com.cas.cglib;

import net.sf.cglib.beans.BeanGenerator;

public class BeanGenTest {
	public void testCgGen() throws Exception {
		BeanGenerator generator = new BeanGenerator();
		generator.addProperty("date", String.class);

		
		Object c = generator.create();
		
	}
}
