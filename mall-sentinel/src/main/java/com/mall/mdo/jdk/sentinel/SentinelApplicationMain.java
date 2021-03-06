package com.mall.mdo.jdk.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelApplicationMain {

    public static void main(String[] args){
        SpringApplication.run(SentinelApplicationMain.class, args);
    }
}
