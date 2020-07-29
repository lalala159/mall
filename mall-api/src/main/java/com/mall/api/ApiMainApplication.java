package com.mall.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author HC
 * @Date 2020/7/29 11:47
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableFeignClients
@EnableTransactionManagement(proxyTargetClass = true)
public class ApiMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiMainApplication.class, args);
    }
}
