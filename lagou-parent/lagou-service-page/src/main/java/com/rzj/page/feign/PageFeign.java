package com.rzj.page.feign;

import com.rzj.common.pojo.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign接口，用于调用服务product的所有方法
 */
@FeignClient(name = "lagou-service-product" ,fallback = PageFeignFallBack.class)
public interface PageFeign {
    @GetMapping("/product/query/{id}")
    public Products query(@PathVariable("id") Integer id);

    @GetMapping("/product/test")
    public String test();
}
