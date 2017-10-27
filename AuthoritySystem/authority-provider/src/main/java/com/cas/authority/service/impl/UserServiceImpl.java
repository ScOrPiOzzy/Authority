package com.cas.authority.service.impl;

import org.springframework.stereotype.Service;

import com.cas.authority.model.User;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.UserService;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {}
