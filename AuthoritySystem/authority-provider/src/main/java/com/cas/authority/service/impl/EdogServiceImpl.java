package com.cas.authority.service.impl;

import com.cas.authority.dao.EdogMapper;
import com.cas.authority.service.EdogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class EdogServiceImpl implements EdogService {
	@Resource
	private EdogMapper edogMapper;

}
