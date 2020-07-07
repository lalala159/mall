package com.mall.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author HC
 * @Date 2020/7/7 14:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableTransactionManagement(proxyTargetClass = true)
public class InfoApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(InfoApplicationMain.class, args);
    }
}
