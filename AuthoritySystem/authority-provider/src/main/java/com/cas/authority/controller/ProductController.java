package com.cas.authority.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.Product;
import com.cas.authority.service.ProductService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Controller
@RequestMapping("/prod")
public class ProductController extends AbstractBaseController{
	@Resource
	private ProductService productService;

	
	@GetMapping("home")
	public String getProdHome() {
		return "admin/user_home";//"admin/prod_home";
	}
	
	
	@GetMapping("form")
	public String getProdForm() {
		return "admin/prod_add_form";
	}

	@PostMapping(value = "add")
	public void insertProduct(@Valid Product product, BindingResult result) {
		productService.save(product);
	}

	@GetMapping("list")
	@ResponseBody
	public Object getProdList() {
		List<Product> listdata = productService.findAll();
		if (listdata == null) {
			return new ArrayList<>();
		}
		return listdata;
	}

}
