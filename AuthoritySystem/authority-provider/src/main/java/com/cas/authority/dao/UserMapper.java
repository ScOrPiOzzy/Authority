package com.cas.authority.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cas.authority.model.User;

@Mapper
public interface UserMapper extends IMapper<User> {}