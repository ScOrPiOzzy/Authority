package com.cas.authority.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.User;
import com.cas.authority.service.UserService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

@Controller
@RequestMapping("/")
public class LoginController extends AbstractBaseController {
	@Resource
	private UserService userService;

	@GetMapping("login_form")
	public String getLoginForm() {
		return "admin/login_form";
	}

	@PostMapping("login")
	@ResponseBody
	public Object login(User user, HttpServletRequest request) {
		Condition condition = new Condition(User.class);
		Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("account", user.getAccount());
		criteria.andEqualTo("passwd", user.getPasswd());
		List<User> users = userService.findByCondition(condition);
//		users size <= 1;
		if (users.size() == 0) {
			return null;
		} else {
			User logon = users.get(0);
			request.getSession().setAttribute("LoginUser", logon);
			return logon;
		}
	}
}
