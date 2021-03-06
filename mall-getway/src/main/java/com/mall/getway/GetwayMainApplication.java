package com.mall.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author HC
 * @Date 2020/5/20 13:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GetwayMainApplication {
    public static void main(String[] args){
        SpringApplication.run(GetwayMainApplication.class, args);
    }
}
