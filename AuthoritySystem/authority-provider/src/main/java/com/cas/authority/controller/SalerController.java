package com.cas.authority.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.Saler;
import com.cas.authority.service.SalerService;

@Controller
@RequestMapping("/saler")
public class SalerController extends AbstractBaseController {
	@Resource
	private SalerService salerService;

	@GetMapping("list")
	public String getUserList() {
		return "admin/saler_list";
	}

	@GetMapping("data_list")
	@ResponseBody
	public Object getSalerList() {
		return salerService.findAll();
	}

	@PostMapping("add")
	@ResponseBody
	public Object addSaler(Saler saler, BindingResult result) {
		if (result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.out.println(objectError.getCode());
			}
			return result.getAllErrors();
		}
		return saler;
	}
}
