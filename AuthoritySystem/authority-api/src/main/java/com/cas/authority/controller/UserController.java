package com.cas.authority.controller;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.vo.User;

@Controller
public class UserController {

	@RequestMapping(value = "/requestForm", method = RequestMethod.GET)
	public String addUserRequest() {
		return "admin/User_Add";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
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
