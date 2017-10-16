package com.cas.authority.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.dao.RegistMapper;
import com.cas.authority.model.Regist;
import com.cas.authority.service.RegistService;

@Service
@Transactional
public class RegistServiceImpl implements RegistService {
	@Resource
	private RegistMapper registMapper;

	@Override
	public void insert(Regist regist) {
		registMapper.insert(regist);
	}

	@Override
	public void insert(List<Regist> regist) {
		registMapper.insertBatch(regist);
	}

	@Override
	public void update(Regist regist) {
		registMapper.update(regist);
	}
}
