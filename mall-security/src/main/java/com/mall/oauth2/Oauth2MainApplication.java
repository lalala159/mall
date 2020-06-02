package com.mall.oauth2;


import com.mall.oauth2.config.AuthorizationParam;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AuthorizationParam.class})
@MapperScan("com.mall.oauth2.dao")
public class Oauth2MainApplication {

    public static void main(String[] args) {

        SpringApplication.run(Oauth2MainApplication.class, args);

    }

}