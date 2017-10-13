package com.cas.authority.controller;

import com.cas.authority.model.Edog;
import com.cas.authority.service.EdogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@RestController
@RequestMapping("/edog")
public class EdogController {
	@Resource
	private EdogService edogService;
//
//	@PostMapping("/add")
//	public Result add(Edog edog) {
//		edogService.save(edog);
//		return ResultGenerator.genSuccessResult();
//	}
//
//	@PostMapping("/delete")
//	public Result delete(@RequestParam Integer id) {
//		edogService.deleteById(id);
//		return ResultGenerator.genSuccessResult();
//	}
//
//	@PostMapping("/update")
//	public Result update(Edog edog) {
//		edogService.update(edog);
//		return ResultGenerator.genSuccessResult();
//	}
//
//	@PostMapping("/detail")
//	public Result detail(@RequestParam Integer id) {
//		Edog edog = edogService.findById(id);
//		return ResultGenerator.genSuccessResult(edog);
//	}
//
//	@PostMapping("/list")
//	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//		PageHelper.startPage(page, size);
//		List<Edog> list = edogService.findAll();
//		PageInfo pageInfo = new PageInfo(list);
//		return ResultGenerator.genSuccessResult(pageInfo);
//	}
}
