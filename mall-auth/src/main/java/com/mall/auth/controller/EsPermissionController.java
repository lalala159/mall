package com.mall.auth.controller;


import com.mall.auth.domain.RouterVO;
import com.mall.auth.service.EsPermissionService;
import com.mall.auth.util.UUIDUtil;
import com.mall.auth.domain.Menu;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsPermission;
import com.mall.common.domain.auth.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/11 14:35
 * @Version 1.0
 */
@RequestMapping(value = "/sys/permission")
@RestController
@Api(tags = "资源管理")
public class EsPermissionController {
    @Autowired
    private EsPermissionService esPermissionService;


    @GetMapping(value = "/getMenuList")
    @ApiOperation("查询菜单")
    @ApiImplicitParam(name = "userName", value = "用户账号", dataType = "String", required = true)
    public Result getMenuList(String userName){
        List<Menu> menuList = esPermissionService.getUserInfo(userName);
        return new Result(200, "查询成功", menuList);
    }

    @GetMapping(value = "/getRouterList")
    @ApiOperation("获取路由")
    @ApiImplicitParam(name = "userName", value = "用户账号", dataType = "String", required = true)
    public Result getRouterList(String userName){
        List<RouterVO> routerList = esPermissionService.getRouter(userName);
        return new Result(200, "查询成功", routerList);
    }

    @GetMapping(value = "/getMenu")
    @ApiOperation("查询菜单")
    @ApiImplicitParam(name = "userName", value = "用户账号", dataType = "String", required = true)
    public Result getMenu(String userName){
        List<MenuVO> menuList = esPermissionService.getMenuList(userName);
        return new Result(200, "查询成功", menuList);
    }

    @PostMapping(value = "/addMenu")
    @ApiOperation("新增资源")
    @ApiImplicitParam(name = "esPermission", value = "资源", dataType = "EsPermission")
    public Result addMenu(EsPermission esPermission){
        esPermission.setUri("exit");
        esPermission.setCreatetime(new Date());
        esPermission.setId(UUIDUtil.getId());
        esPermissionService.addMenu(esPermission);
        return new Result(200, "新增成功");
    }

    @DeleteMapping(value = "/deleteMenu")
    @ApiOperation("删除资源")
    @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
    public Result deleteMenu(String id){
        esPermissionService.deleteByPrimaryKey(id);
        return new Result(200, "删除成功");
    }


}
