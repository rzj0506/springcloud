package com.rzj.product.controller;

import com.rzj.common.pojo.Products;
import com.rzj.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/query/{id}")
    public Products query(@PathVariable("id") Integer id){
       return productService.findById(id);
    }
    @GetMapping("/test")
    public String test(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2";
    }
}
