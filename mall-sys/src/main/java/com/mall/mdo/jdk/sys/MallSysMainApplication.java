package com.mall.mdo.jdk.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Author HC
 * @Date 2020/5/20 10:25
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MallSysMainApplication {
    public static void main(String[] args){
        SpringApplication.run(MallSysMainApplication.class, args);
    }
}
