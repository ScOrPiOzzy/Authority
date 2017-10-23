package com.cas.authority.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.Consts;
import com.cas.authority.model.AuthorityEntity;
import com.cas.authority.model.Regist;
import com.cas.authority.model.UserRegistEntity;
import com.cas.authority.service.RecordService;
import com.cas.authority.service.RegistService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

@Controller
@RequestMapping("/regist")
public class RegistController extends AbstractBaseController {
	@Resource
	private RecordService recordService;
	@Resource
	private RegistService registService;

	@GetMapping("time_mills")
	@ResponseBody
	public Long getTime() {
		return System.currentTimeMillis();
	}

	@GetMapping("form/{record_id}")
	public String getForm(@PathVariable("record_id") Integer rid, Model model) {
		model.addAttribute("record_id", rid);
		return "admin/regist_add_form";
	}

	/**
	 * 生成证书
	 */
	@PostMapping("active")
	@ResponseBody
	public Object generateAuthorityFile(@Valid AuthorityEntity entity, BindingResult result) {
		if (result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.err.println(objectError.getDefaultMessage());
			}
			return null;
		}

//		收到客户请求的注册码
		logger.info("收到客户注册信息：用户名" + entity.getCustomName() + "，注册码:" + entity.getCode());
//		if (regCode == null || "".equals(regCode)) {
//			return null;
//		}
//		try {
//			regCode = RSAUtil.descryptByPrivateKey(KeyStoreUtil.getPrivateKey(getClass().getClassLoader().getResourceAsStream(Consts.FILE_KYESTORE), "www.wxcas.com", "cas123", "cas123"), regCode);
//		} catch (Exception e) {
//			return getMessage("regist.code.invalid.error");
//		}

		UserRegistEntity record = recordService.findRecord(entity.getCode(), entity.getCustomName());
		boolean valid = record != null && record.getRegistUsed() != 1;
		if (valid) {
//			服务器验证通过后，
//			1、将客户端提交的数据保存
			entity.getCpuSer();
			Regist reg = new Regist();
			reg.setId(record.getRegistId());
			reg.setSer_hdd(entity.getHddSer());
			reg.setSer_cpu(entity.getCpuSer());
			reg.setUsed(1);
//			2、将有效期和节点数发送给用户
			entity.setCompanyName(Consts.COMPANY_NAME);
			entity.setFromDate("2017-09-22");
			entity.setEndDate("2018-09-22");
			entity.setNode(5);

			registService.update(reg);
			return entity;
		} else {
			return null;
		}
	}

	@GetMapping("list/{rid}")
	public String showRegistListPage(@PathVariable(value = "rid") Integer recordId, Model model) {
		model.addAttribute("record_id", recordId);
		return "admin/regist_list";
	}

	@RequestMapping("data_list")
	@ResponseBody
	public Object showRegistDataList(HttpServletRequest request, Model model) {
		Condition condition_belong_record = new Condition(Regist.class);
		Criteria criteria = condition_belong_record.createCriteria();
		int recordId = Integer.parseInt(request.getParameter("recordId"));// 所属的销售记录
		criteria.andEqualTo("record_id", recordId);
		return registService.findByCondition(condition_belong_record);
	}

	@RequestMapping("page_list")
	@ResponseBody
	public Object showRegistPageList(HttpServletRequest request, Model model) {
		Condition condition_belong_record = new Condition(Regist.class);
		Criteria criteria = condition_belong_record.createCriteria();
		int recordId = Integer.parseInt(request.getParameter("recordId"));// 所属的销售记录
		criteria.andEqualTo("record_id", recordId);

		int total = registService.getTotalBy(condition_belong_record);
//		System.err.println("total:" + total);
		int page = Integer.parseInt(request.getParameter("page"));// 当前页
		int rows = Integer.parseInt(request.getParameter("rows"));// 每页条数
//		List<User> data = userService.getCurrentPage((page - 1) * rows, rows);
//		System.out.println("===显示页码：" + page + ", 每页条数： " + rows);
		PageHelper.startPage(page, rows, false);
		List<Regist> registList = registService.findByCondition(condition_belong_record);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", registList);
		map.put("total", total);
		return map;
	}

	@PostMapping("/add")
	@ResponseBody
	public Object addRegist(@Valid Regist regist, BindingResult result) {
		registService.save(regist);
		return regist;
	}
}
