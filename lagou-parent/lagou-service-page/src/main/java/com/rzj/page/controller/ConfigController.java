package com.rzj.page.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${student.name}")
    private String name;
   @Value("${student.age}")
    private String age;


    @GetMapping("/get")
    public String getMessage(){
        return name+","+age;
    }
}
