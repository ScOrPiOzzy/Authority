package com.cas.authority.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.service.SalerService;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
@RestController
@RequestMapping("/saler")
public class SalerController {
	@Resource
	private SalerService salerService;

//    @PostMapping("/add")
//    public Result add(Saler saler) {
//        salerService.save(saler);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        salerService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Saler saler) {
//        salerService.update(saler);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Saler saler = salerService.findById(id);
//        return ResultGenerator.genSuccessResult(saler);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Saler> list = salerService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
