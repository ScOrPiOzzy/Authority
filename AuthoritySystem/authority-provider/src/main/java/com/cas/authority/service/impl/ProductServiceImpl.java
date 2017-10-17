package com.cas.authority.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.model.Product;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.ProductService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
	
}
