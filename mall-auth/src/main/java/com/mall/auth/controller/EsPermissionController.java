package com.mall.auth.controller;


import com.mall.auth.domain.Menu;
import com.mall.auth.domain.RouterVO;
import com.mall.auth.service.EsPermissionService;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsPermission;
import com.mall.common.domain.auth.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping(value = "/getMenu")
    public Result getMenu(){
        List<MenuVO> menuList = esPermissionService.getMenuList();
        return new Result(200, "查询成功", menuList);
    }

    @PostMapping(value = "/addMenu")
    public Result addMenu(EsPermission esPermission){
        esPermission.setUri("exit");
        esPermission.setCreatetime(new Date());
        esPermissionService.addMenu(esPermission);
        return new Result(200, "新增成功");
    }

    @DeleteMapping(value = "/deleteMenu")
    public Result deleteMenu(Integer id){
        esPermissionService.deleteByPrimaryKey(id);
        return new Result(200, "删除成功");
    }


}
