package com.slasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker   //开启断路器功能，
@EnableDiscoveryClient
@SpringBootApplication
/**
 * 也可以使用spring cloud应用中的@SpringCloudApplication注解来修饰主类，因为该注解包含了
 * @EnableCircuitBreaker
 * @EnableDiscoveryClient
 * @SpringBootApplication
 * 这三个注解
 */
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

}
