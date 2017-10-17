package com.cas.authority.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cas.authority.model.RecordDetail;
import com.cas.authority.service.RecordService;
import com.github.pagehelper.PageHelper;

@Controller
public class IndexController extends AbstractBaseController {

	@Resource
	private RecordService recordService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@ResponseBody
	public Object getIndex(Model model) {

//		1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(1, 3, false);

//		List<RecordDetail> recordList = recordService.getAllRecord();
		List<RecordDetail> recordList = recordService.findAllDetail();
		
//		PageBean<Record> pageData = new PageBean<>(1, 3, 1);
		
		System.err.println(recordList.size());

		model.addAttribute("recordList", recordList);


		return "admin/index";
//		return recordList;
	}
}
