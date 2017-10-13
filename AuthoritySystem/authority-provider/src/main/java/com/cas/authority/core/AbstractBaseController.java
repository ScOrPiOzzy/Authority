package com.cas.authority.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractBaseController {

	@Resource
	private MessageSource messageSource; // 自动注入对象

	public String getMessage(String key, String... args) {
		return this.messageSource.getMessage(key, args, Locale.getDefault());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 明确地描述此时需要注册一个日期格式的转化处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
