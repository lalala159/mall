package com.mall.auth.controller;


import com.mall.auth.service.EsPermissionService;
import com.mall.common.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author HC
 * @Date 2020/6/11 14:35
 * @Version 1.0
 */
@RequestMapping(value = "/sys/permission")
@RestController
public class EsPermissionController {
    @Autowired
    private EsPermissionService esPermissionService;


    @GetMapping(value = "/getUserInfo")
    public Result getUserInfo(String userName){
        List<Map<String, Object>> list = esPermissionService.getUserInfo(userName);
        return new Result(200, "查询成功", list);
    }


}
