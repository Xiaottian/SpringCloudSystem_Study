package com.slasher.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;

@Service
public class HelloService {

    private final Logger logger = (Logger) Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    RestTemplate restTemplate;

    /**
     HystrixCommand:用在依赖的服务返回单个操作结果的时候
     HystrixObservableCommand：用在依赖的服务返回多个操作结果的时候

     ！！命令模式！！：将来自客户端的请求封装成一个对象，从而使用不同的请求对客户端进行参数化
     可以用于实现“行为请求者”与“行为实现者”的解耦，使两者可以适应变化
     */
    @HystrixCommand(fallbackMethod = "helloFallback")   //指定回调方法
    public String helloService(){
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("spend time : " + (end - start));
        return result.toString();
    }

    public String helloFallback(){
        return "error";
    }
}
