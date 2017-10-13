package com.cas.authority.service.impl;

import com.cas.authority.dao.ProductCategoryMapper;
import com.cas.authority.model.ProductCategory;
import com.cas.authority.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

}
