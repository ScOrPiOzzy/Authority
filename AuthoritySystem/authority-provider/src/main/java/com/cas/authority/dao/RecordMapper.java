package com.cas.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cas.authority.model.Record;
import com.cas.authority.model.RecordDetail;
import com.cas.authority.model.UserRegistEntity;

@Mapper
public interface RecordMapper extends IMapper<Record> {

	UserRegistEntity selectBy(String registCode, String userUnit);

	List<RecordDetail> selectAllDetail();

	RecordDetail selectDetailBy(Integer id);
}