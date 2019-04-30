package com.slasher;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableFeignClients //开启spring cloud feign
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

    /**
     * feign客户端默认的Logger.level对象定义为NONE级别，该级别不记录任何Feign调用过程中的信息，，所以需要调整级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}
