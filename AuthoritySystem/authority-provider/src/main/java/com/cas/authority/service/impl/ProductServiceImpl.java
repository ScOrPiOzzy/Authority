package com.cas.authority.service.impl;

import com.cas.authority.dao.ProductMapper;
import com.cas.authority.model.Product;
import com.cas.authority.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;

}
