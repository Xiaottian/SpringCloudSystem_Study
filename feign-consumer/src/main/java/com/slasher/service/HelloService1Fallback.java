package com.slasher.service;

import com.slasher.bean.User;
import org.springframework.stereotype.Component;

@Component
public class HelloService1Fallback implements HelloService1 {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
