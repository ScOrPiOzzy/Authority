package com.cas.authority.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.model.Product;
import com.cas.authority.service.ProductService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;

	@PostMapping(value="add")
	public void insertProduct(@Valid Product product, BindingResult result) {
		productService.save(product);
	}
}
