package com.cas.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends AbstractBaseController {
	@GetMapping("/")
	public Object getIndex(Model model) {
		return "admin/index";
	}
}
