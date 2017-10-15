package com.cas.authority.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cas.authority.model.Record;
import com.cas.authority.model.UserRegistEntity;

@Mapper
public interface RecordMapper {
	void insert(Record record);

	UserRegistEntity selectBy(String registCode, String userUnit);

}