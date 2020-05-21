package com.mall.sys.controller;

import com.mall.sys.domain.JkglUser;
import com.mall.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HC
 * @Date 2020/5/20 10:29
 * @Version 1.0
 */
@RestController
@RefreshScope
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/getUser/getById/{id}")
    public JkglUser getUser(@PathVariable(value = "id") Integer id){
        JkglUser jkglUser = userService.selectByPrimaryKey(id);
        return jkglUser;
    }
}
