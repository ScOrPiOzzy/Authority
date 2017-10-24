package com.cas.authority.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.User;
import com.cas.authority.service.UserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractBaseController {
	@Resource
	private UserService userService;

	@GetMapping("form")
	public String getProdForm() {
		return "admin/user_add_form";
	}

	@GetMapping("list")
	public String getUserList() {
		return "admin/user_list";
	}

	@GetMapping("data_list")
	@ResponseBody
	public List<User> getUserDataList() {
		return userService.findAll();
	}

	@GetMapping("data_custom_list")
	@ResponseBody
	public List<User> getCustomDataList() {
		Condition condition_saler = new Condition(User.class);
		Criteria criteria = condition_saler.createCriteria();
		criteria.andEqualTo("role", "0");
		return userService.findByCondition(condition_saler);
	}

	@GetMapping("data_saler_list")
	@ResponseBody
	public List<User> getSalerDataList() {
		Condition condition_saler = new Condition(User.class);
		Criteria criteria = condition_saler.createCriteria();
		criteria.andEqualTo("role", "1");
		return userService.findByCondition(condition_saler);
	}

	@GetMapping("data_dev_list")
	@ResponseBody
	public List<User> getDevDataList() {
		Condition condition_saler = new Condition(User.class);
		Criteria criteria = condition_saler.createCriteria();
		criteria.andEqualTo("role", "2");
		return userService.findByCondition(condition_saler);
	}

	@GetMapping("data_mgr_list")
	@ResponseBody
	public Object getMgrDataList() {
		Condition condition_saler = new Condition(User.class);
		Criteria criteria = condition_saler.createCriteria();
		criteria.andEqualTo("role", "3");
		return userService.findByCondition(condition_saler);
	}

	@GetMapping("page_list")
	@ResponseBody
	public Object getUserPageList(HttpServletRequest request) {
		int total = userService.getTotal();
		int page = Integer.parseInt(request.getParameter("page"));// 当前页
		int rows = Integer.parseInt(request.getParameter("rows"));// 每页条数
		PageHelper.startPage(page, rows, false);
		List<User> data = userService.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		map.put("total", total);
		return map;
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
		} else {
			userService.save(user);
		}
		return user;
	}
}
