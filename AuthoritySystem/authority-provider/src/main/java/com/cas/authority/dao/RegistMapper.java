package com.cas.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cas.authority.model.Regist;

@Mapper
public interface RegistMapper {

	public void insert(Regist regist);

	public void insertBatch(List<Regist> regist);

	public void update(Regist regist);

}
