package com.cas.authority.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cas.authority.dao.UserMapper;
import com.cas.authority.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

}
