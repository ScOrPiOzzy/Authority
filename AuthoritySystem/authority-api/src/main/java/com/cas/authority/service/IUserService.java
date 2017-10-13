package com.cas.authority.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cas.authority.vo.User;

@Service
public interface IUserService {
	public List<User> getUserList();
}
