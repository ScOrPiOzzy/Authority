package com.cas.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cas.authority.vo.User;

@Mapper
public interface IUserDao {
	List<User> findAll();
}
