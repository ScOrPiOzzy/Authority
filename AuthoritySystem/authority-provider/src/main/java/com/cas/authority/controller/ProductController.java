package com.cas.authority.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.Product;
import com.cas.authority.service.ProductService;
import com.github.pagehelper.PageHelper;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Controller
@RequestMapping("/prod")
public class ProductController extends AbstractBaseController {
	@Resource
	private ProductService productService;

	@GetMapping("form")
	public String getProdForm() {
		return "admin/prod_add_form";
	}

	@PostMapping(value = "add")
	@ResponseBody
	public Object insertProduct(@Valid Product product, BindingResult result) {
		productService.save(product);
		return product;
	}

	@GetMapping("list")
	public String getUserList() {
		return "admin/prod_list";
	}

	@GetMapping("data_list")
	@ResponseBody
	public List<Product> getProdDataList() {
		return productService.findAll();
	}

	@GetMapping("page_list")
	@ResponseBody
	public Map<String, Object> getProdPageList(HttpServletRequest request) {
		int total = productService.getTotal();
		int page = Integer.parseInt(request.getParameter("page"));// 当前页
		int rows = Integer.parseInt(request.getParameter("rows"));// 每页条数
		PageHelper.startPage(page, rows, false);
		List<Product> data = productService.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		map.put("total", total);

		return map;
	}

}
