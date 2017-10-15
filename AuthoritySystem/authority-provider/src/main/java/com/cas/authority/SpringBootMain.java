package com.cas.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 启动SpringBoot程序，自带子包扫描
public class SpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

//	// 配置mybatis的分页插件pageHelper
//	@Bean
//	public PageHelper pageHelper() {
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum", "true");
//		properties.setProperty("rowBoundsWithCount", "true");
//		properties.setProperty("reasonable", "true");
//		properties.setProperty("dialect", "mysql"); // 配置mysql数据库的方言
//
//		PageHelper pageHelper = new PageHelper();
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}
}
