package com.mall.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableTransactionManagement(proxyTargetClass=true)
public class AuthMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMainApplication.class, args);
    }
}
