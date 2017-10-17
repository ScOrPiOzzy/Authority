package com.cas.authority.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.dao.RecordMapper;
import com.cas.authority.model.Record;
import com.cas.authority.model.RecordDetail;
import com.cas.authority.model.UserRegistEntity;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.RecordService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class RecordServiceImpl extends AbstractService<Record> implements RecordService {

	@Override
	public List<RecordDetail> findAllDetail() {
		RecordMapper m = (RecordMapper) mapper;
		return m.selectAllDetail();
	}

	@Override
	public UserRegistEntity findRecord(String code, String customName) {
		RecordMapper m = (RecordMapper) mapper;
		return m.selectBy(code, customName);
	}
}
