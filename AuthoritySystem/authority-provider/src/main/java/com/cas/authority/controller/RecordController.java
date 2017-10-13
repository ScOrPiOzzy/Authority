package com.cas.authority.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.service.RecordService;

/**
* Created by CodeGenerator on 2017/10/13.
*/
@RestController
@RequestMapping("/record")
public class RecordController {
    @Resource
    private RecordService recordService;

//    @PostMapping("/add")
//    public Result add(Record record) {
//        recordService.save(record);
//        return ResultGenerator.genSuccessResult();
//    }
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
