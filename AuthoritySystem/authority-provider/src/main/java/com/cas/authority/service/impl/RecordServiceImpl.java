package com.cas.authority.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.dao.RecordMapper;
import com.cas.authority.model.Record;
import com.cas.authority.model.RecordDetail;
import com.cas.authority.model.UserRegistEntity;
import com.cas.authority.service.RecordService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class RecordServiceImpl implements RecordService {
	@Resource
	private RecordMapper recordMapper;

	@Override
	public List<RecordDetail> getAllRecord() {
		return recordMapper.selectAllDetail();
	}

	@Override
	public List<Record> getAllRecordPO() {
		return recordMapper.selectAll();
	}

	@Override
	public UserRegistEntity getRecord(String registCode, String userUnit) {
		return recordMapper.selectBy(registCode, userUnit);
	}
}
