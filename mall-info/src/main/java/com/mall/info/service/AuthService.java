package com.mall.info.service;

import com.mall.common.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @Author HC
 * @Date 2020/7/22 15:01
 * @Version 1.0
 */
@Component
@FeignClient(value = "mall-auth")
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    ResponseUtil<Map<String, Object>> getToken(Map<String, Object> map);
}
