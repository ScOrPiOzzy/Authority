package com.cas.authority.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cas.authority.model.Record;
import com.cas.authority.model.RecordDetail;
import com.cas.authority.service.RecordService;
import com.github.pagehelper.PageHelper;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@Controller
@RequestMapping("record")
public class RecordController extends AbstractBaseController {
	@Resource
	private RecordService recordService;

	@GetMapping("form")
	public String getProdForm() {
		return "admin/record_add_form";
	}

	@RequestMapping("page")
	public String getPageUI() {
		return "admin/record_list";
	}

	@PostMapping("add")
	@ResponseBody
	public Object add(@Valid Record record, BindingResult result) {
		if (result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.out.println(objectError.getDefaultMessage());
			}
			return result.getAllErrors();
		}
		System.out.println("===插入数据前：" + record.getId());
		recordService.save(record);
		System.out.println("===插入数据后：" + record.getId());

		RecordDetail recordDetail = recordService.findDetailBy(record.getId());
		return recordDetail;
	}

	/**
	 * 分页请求地址
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("page_list")
	@ResponseBody
	public Map<String, Object> getRecordPageList(HttpServletRequest request) {
		int total = recordService.getTotal();
		int page = Integer.parseInt(request.getParameter("page"));// 当前页
		int rows = Integer.parseInt(request.getParameter("rows"));// 每页条数
		PageHelper.startPage(page, rows, false);
		List<RecordDetail> data = recordService.findAllDetail();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		map.put("total", total);
		return map;
	}

	@GetMapping("data_list")
	@ResponseBody
	public List<RecordDetail> getRecordDataList() {
		return recordService.findAllDetail();
	}

}
