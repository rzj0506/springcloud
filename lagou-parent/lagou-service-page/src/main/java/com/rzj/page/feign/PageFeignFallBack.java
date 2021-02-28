package com.rzj.page.feign;

import com.rzj.common.pojo.Products;
import org.springframework.stereotype.Component;

@Component
public class PageFeignFallBack implements PageFeign {
    @Override
    public Products query(Integer id) {
        return null;
    }

    @Override
    public String test() {
        return "服务降级了！！";
    }
}
