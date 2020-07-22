package com.mall.info.controller;

import com.mall.common.ResponseUtil;
import com.mall.info.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author HC
 * @Date 2020/7/22 15:00
 * @Version 1.0
 */
@RestController
@RequestMapping("sys/auth")
public class AuthController {
    @Resource
    private AuthService authService;

    @PostMapping("/token")
    public ResponseUtil<Map<String, Object>> getPaumentByid(Map<String, Object> map) {
        return authService.getToken(map);
    }
}
