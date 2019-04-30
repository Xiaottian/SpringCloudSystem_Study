package com.slasher.service;

import com.slasher.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
// fallback属性指定对应的服务降级实现类
@FeignClient(value = "hello-service",fallback = HelloService1Fallback.class)   //服务名不区分大小写，所以使用hello-service和HELLO-SERVICE都可以
public interface HelloService1 {
    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name")String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name")String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
