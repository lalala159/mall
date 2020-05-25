package com.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignMain {
    public static void main(String[] args){
        SpringApplication.run(OrderOpenfeignMain.class, args);
    }
}
