package com.cas.authority.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cas.authority.dao.IUserDao;
import com.cas.authority.service.IUserService;
import com.cas.authority.vo.User;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.findAll();
	}

}
