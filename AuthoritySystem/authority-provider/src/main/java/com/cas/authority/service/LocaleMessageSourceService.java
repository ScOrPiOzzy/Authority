package com.cas.authority.service;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageSourceService {
	@Resource
	private MessageSource messageSource;
}
