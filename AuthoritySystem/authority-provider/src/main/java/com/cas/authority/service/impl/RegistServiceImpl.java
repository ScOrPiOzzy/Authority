package com.cas.authority.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.model.Regist;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.RegistService;

@Service
@Transactional
public class RegistServiceImpl extends AbstractService<Regist> implements RegistService {
}
