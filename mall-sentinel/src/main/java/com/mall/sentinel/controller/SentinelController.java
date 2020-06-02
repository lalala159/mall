package com.mall.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        return "....../A";
    }

    @GetMapping("/testB")
    public String testB(){
        return "....../B";
    }
}
