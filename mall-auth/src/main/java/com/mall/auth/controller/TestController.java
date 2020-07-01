package com.mall.auth.controller;

import com.mall.common.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HC
 * @Date 2020/7/1 17:26
 * @Version 1.0
 */
@RequestMapping(value = "docker")
public class TestController {
    @GetMapping(value = "test")
    public Result test(){
        return Result.success("1.0");
    }
}
