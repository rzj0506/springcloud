package com.rzj.page.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rzj.common.pojo.Products;
import com.rzj.page.feign.PageFeign;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/page")
public class PageController {
   @Autowired
   private PageFeign pageFeign;
    @GetMapping("/getData/{id}")
    public Products getData(@PathVariable("id") Integer id){
       return pageFeign.query(id);
    }

    /**负载均衡
     *
     */
    @GetMapping("loadBalance")
    public String loadBalance(){
        return pageFeign.test();
    }


    /**
     * 服务熔断
     */
    @GetMapping("loadBalance2")
    @HystrixCommand(
            threadPoolKey = "loadBalance2",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "1"),
                    @HystrixProperty(name = "maxQueueSize",value = "20")
            },
            commandProperties = {
                                //统计窗口时间的设置
                                @HystrixProperty(name =
            "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                                //统计窗口内的最小请求数
                                @HystrixProperty(name =
            "circuitBreaker.requestVolumeThreshold",value = "2"),
                                //统计窗口内错误请求阈值的设置 50%
                                @HystrixProperty(name =
            "circuitBreaker.errorThresholdPercentage",value = "50"),
                                //自我修复的活动窗口时间
                                @HystrixProperty(name =
            "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
                      },
            fallbackMethod = "loadBalance2Fallback"
    )


    public String loadBalance2(){
        return pageFeign.test();
    }


}
