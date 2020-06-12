package com.mall.auth.controller;


import com.mall.auth.domain.Menu;
import com.mall.auth.domain.RouterVO;
import com.mall.auth.service.EsPermissionService;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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


    @GetMapping(value = "/getMenuList")
    public Result getMenuList(String userName){
        List<Menu> menuList = esPermissionService.getUserInfo(userName);
        return new Result(200, "查询成功", menuList);
    }

    @GetMapping(value = "/getRouterList")
    public Result getRouterList(String userName){
        List<RouterVO> routerList = esPermissionService.getRouter(userName);
        return new Result(200, "查询成功", routerList);
    }


}
