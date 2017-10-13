package com.cas.authority.service.impl;

import com.cas.authority.dao.SalerMapper;
import com.cas.authority.model.Saler;
import com.cas.authority.service.SalerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class SalerServiceImpl implements SalerService {
	@Resource
	private SalerMapper salerMapper;

}
