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

import com.cas.authority.model.User;
import com.cas.authority.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends AbstractBaseController {
	@Resource
	private UserService userService;

	@GetMapping("home")
	public String getUserForm() {
		return "admin/user_home";
	}

	@GetMapping("list")
	@ResponseBody
	public Object getSalerList() {
		List<User> listdata = userService.findAll();
		if(listdata == null) {
			return new ArrayList<>();
		}
		return listdata;
	}

	@PostMapping("add")
	@ResponseBody
	public Object addUser(User user, BindingResult result) {
		if (result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.out.println(objectError.getCode());
			}
			return result.getAllErrors();
		}
		return user;
	}
}
