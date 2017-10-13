package com.cas.authority.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.service.OrgnizationService;

/**
* Created by CodeGenerator on 2017/10/13.
*/
@RestController
@RequestMapping("/orgnization")
public class OrgnizationController {
    @Resource
    private OrgnizationService orgnizationService;

//    @PostMapping("/add")
//    public Result add(Orgnization orgnization) {
//        orgnizationService.save(orgnization);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        orgnizationService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Orgnization orgnization) {
//        orgnizationService.update(orgnization);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Orgnization orgnization = orgnizationService.findById(id);
//        return ResultGenerator.genSuccessResult(orgnization);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Orgnization> list = orgnizationService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
