package com.slasher.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//启用刷新
@RestController
public class TestController {

    /**
     * 除了可以通过@value注解进行值绑定外，还可以使用Environment对象来获取配置属性
     */
    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }
}
