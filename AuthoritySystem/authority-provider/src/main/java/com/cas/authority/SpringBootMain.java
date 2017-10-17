package com.cas.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.druid.filter.AutoLoad;

@SpringBootApplication // 启动SpringBoot程序，自带子包扫描
@AutoLoad
public class SpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

}
