package com.rzj.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.rzj.product.mapper")
public class ProductApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication9002.class,args);
    }
}
