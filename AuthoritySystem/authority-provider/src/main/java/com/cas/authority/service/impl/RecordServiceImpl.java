package com.cas.authority.service.impl;

import com.cas.authority.dao.RecordMapper;
import com.cas.authority.model.Record;
import com.cas.authority.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class RecordServiceImpl implements RecordService {
	@Resource
	private RecordMapper recordMapper;

}
