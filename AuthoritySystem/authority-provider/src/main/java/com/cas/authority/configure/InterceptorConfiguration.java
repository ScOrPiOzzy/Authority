package com.cas.authority.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cas.authority.interecptor.LoginInterceptor;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration registion = registry.addInterceptor(new LoginInterceptor());
		registion.addPathPatterns("/");
		registion.addPathPatterns("/prod");
		registion.addPathPatterns("/record");
		registion.addPathPatterns("/user");
		registion.excludePathPatterns("/login", "/login_form");
		registion.excludePathPatterns("/regist/time_mills", "/regist/active");
		super.addInterceptors(registry);
	}
}
