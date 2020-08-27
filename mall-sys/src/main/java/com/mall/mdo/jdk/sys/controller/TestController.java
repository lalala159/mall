package com.mall.mdo.jdk.sys.controller;

import com.mall.common.ResponseUtil;
import com.mall.mdo.jdk.sys.service.UserService;
import com.mall.mdo.jdk.sys.domain.JkglUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getUser/getById/{id}")
    @PreAuthorize("hasAnyAuthority('select')")
    public ResponseUtil getUser(@PathVariable(value = "id") Integer id) {
        JkglUser jkglUser = userService.selectByPrimaryKey(id);
        return new ResponseUtil(200, "成功1,serverPort:" + serverPort, jkglUser);
    }
}
