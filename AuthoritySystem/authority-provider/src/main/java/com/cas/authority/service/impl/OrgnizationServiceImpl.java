package com.cas.authority.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.dao.OrgnizationMapper;
import com.cas.authority.service.OrgnizationService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class OrgnizationServiceImpl implements OrgnizationService {
	@Resource
	private OrgnizationMapper orgnizationMapper;

}
