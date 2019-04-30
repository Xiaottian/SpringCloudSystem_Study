package com.slasher.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.slasher.bean.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCollapser(batchMethod = "findAll",collapserProperties = {@HystrixProperty(name = "timerDelayInMillseconds",value = "100")})
    public User find(Long id){
        return null;
    }

    @HystrixCommand
    public List<User> findAll(List<Long> ids){
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}",
                List.class, StringUtils.join(ids,","));
    }

    @HystrixCommand(fallbackMethod = "defaultUser")     //定义hystrix命令的实现，同步方法执行
    public User getUserById(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                User.class,id);
    }

    @HystrixCommand     //定义hystrix命令的实现，异步方法执行
    public Future<User> getUserByIdAsync(final String id){
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                        User.class,id);
            }
        };


    }

    @HystrixCommand(fallbackMethod = "defaultUserSec")
    public User defaultUser(){
        return new User("First Fallback");
    }

    public User defaultUserSec(){
        return new User("Second Fallback");
    }
}
