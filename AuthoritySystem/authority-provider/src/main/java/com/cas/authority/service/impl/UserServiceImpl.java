package com.cas.authority.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cas.authority.dao.UserMapper;
import com.cas.authority.model.Record;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.UserService;

@Service
public class UserServiceImpl extends AbstractService<Record> implements UserService {
	@Resource
	private UserMapper userMapper;

}
