package com.cas.authority.controller;
import com.cas.authority.model.Product;
import com.cas.authority.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

//    @PostMapping("/add")
//    public Result add(Product product) {
//        productService.save(product);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        productService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Product product) {
//        productService.update(product);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Product product = productService.findById(id);
//        return ResultGenerator.genSuccessResult(product);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Product> list = productService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}