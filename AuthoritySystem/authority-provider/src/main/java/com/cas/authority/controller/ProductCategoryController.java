package com.cas.authority.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.authority.service.ProductCategoryService;

/**
* Created by CodeGenerator on 2017/10/13.
*/
@RestController
@RequestMapping("/product/category")
public class ProductCategoryController {
    @Resource
    private ProductCategoryService productCategoryService;

//    @PostMapping("/add")
//    public Result add(ProductCategory productCategory) {
//        productCategoryService.save(productCategory);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        productCategoryService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(ProductCategory productCategory) {
//        productCategoryService.update(productCategory);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        ProductCategory productCategory = productCategoryService.findById(id);
//        return ResultGenerator.genSuccessResult(productCategory);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<ProductCategory> list = productCategoryService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
