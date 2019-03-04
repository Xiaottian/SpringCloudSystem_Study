package com.slasher.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SlasherEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlasherEurekaServerApplication.class, args);
    }

}

