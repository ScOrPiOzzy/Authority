package com.cas.authority.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.AuthorityEntity;
import com.cas.authority.model.Record;
import com.cas.authority.model.Regist;
import com.cas.authority.service.RecordService;
import com.cas.authority.service.RegistService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

@Controller
@RequestMapping(value = "authority")
public class RegistController extends AbstractBaseController {
	@Resource
	private RecordService recordService;
	@Resource
	private RegistService registService;

	/**
	 * 生成证书
	 */
	@RequestMapping(path = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public Object generateAuthorityFile(@Valid AuthorityEntity entity, BindingResult result) {
		if (result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.err.println(objectError.getDefaultMessage());
			}
			return result.getAllErrors();
		}

//		收到客户请求的注册码
		String regCode = entity.getCode();
		System.out.println("收到客户注册码:" + regCode);
//		if (regCode == null || "".equals(regCode)) {
//			return null;
//		}
//		try {
//			regCode = RSAUtil.descryptByPrivateKey(KeyStoreUtil.getPrivateKey(getClass().getClassLoader().getResourceAsStream(Consts.FILE_KYESTORE), "www.wxcas.com", "cas123", "cas123"), regCode);
//		} catch (Exception e) {
//			return getMessage("regist.code.invalid.error");
//		}

//		开始验证注册码
		boolean valid = validate(entity);

		if (valid) {
//			服务器验证通过后，
//			1、将客户端提交的数据保存
			entity.getHddSer();
			entity.getCpuSer();
//			2、将有效期和节点数发送给用户
			entity.setFromDate("2017-09-22");
			entity.setEndDate("2018-09-22");
			entity.setNode(5);

			return entity;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/regist_list/{rid}", method = RequestMethod.GET)
	public String showRegistList(@PathVariable(value = "rid") Integer recordId, Model model) {
		Condition condition = new Condition(Regist.class);
		Criteria criteria = condition.createCriteria();
		System.out.println(recordId);
		criteria.andEqualTo("record_id", recordId);
		List<Regist> registList = registService.findByCondition(condition);
		model.addAttribute("registList", registList);
		return "admin/user_regist_list";
	}

	@RequestMapping(value = "/add_register", method = RequestMethod.POST)
	@ResponseBody
	public Object addRegist(@Valid Regist regist, BindingResult result) {
		registService.save(regist);
		return regist;
	}

	private boolean validate(AuthorityEntity entity) {
//		查询数据库，是否存在
		Object r = recordService.findRecord(entity.getCode(), entity.getCustomName());
		return r != null;
	}
}
