package com.cas.authority.controller;

import java.util.Iterator;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.model.Record;
import com.cas.authority.service.RecordService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@RestController
@RequestMapping("/record")
public class RecordController extends AbstractBaseController{
	@Resource
	private RecordService recordService;

	@PostMapping("add")
	@ResponseBody
	public Object add(@Valid Record record, BindingResult result) {
		if(result.hasErrors()) {
			Iterator<ObjectError> iter = result.getAllErrors().iterator();
			while (iter.hasNext()) {
				ObjectError objectError = (ObjectError) iter.next();
				System.out.println(objectError.getDefaultMessage());
			}
			return result.getAllErrors();
		}
		recordService.save(record);
		return record;
	}
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        recordService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Record record) {
//        recordService.update(record);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Record record = recordService.findById(id);
//        return ResultGenerator.genSuccessResult(record);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Record> list = recordService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
