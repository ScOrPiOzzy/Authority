package com.cas.authority.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.service.EdogService;

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
