package com.mall.auth.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.EsRoleService;
import com.mall.auth.util.UUIDUtil;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/15 16:10
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sys/role")
@Api(tags = "角色管理")
public class EsRoleController {
    @Autowired
    private EsRoleService esRoleService;

    @GetMapping(value = "/queryList")
    @ApiOperation("获取角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Integer")
    })
    public PageInfo queryList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EsRole> list = esRoleService.queryList();
        return new PageInfo(list);
    }

    @PostMapping(value = "/addMenu")
    @ApiOperation("分配菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色编码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "menuIds", value = "菜单集合", required = true, dataType = "String")
    })
    public Result addMenu(String roleId, String menuIds) {
        String[] menus = menuIds.split(",");
        int flag = esRoleService.addMenu(roleId, menus);
        return new Result(200, "设置成功");
    }

    @GetMapping(value = "/getPermissioned")
    @ApiOperation("获取资源")
    @ApiImplicitParam(name = "roleId", value = "角色编码", required = true, dataType = "String")
    public Result getPermissioned(String roleId) {
        List<Integer> list;
        if(roleId == null){
            list = null;
        }else{
            list = esRoleService.getPermissioned(roleId);
        }
        return new Result(200, "查询成功", list);
    }

    @PostMapping(value = "/addRole")
    @ApiOperation("新增角色")
    @ApiImplicitParam(name = "esRole", value = "角色", dataType = "EsRole")
    public Result addRole(EsRole esRole) {
        try{
            esRole.setValid(true);
            esRole.setId(UUIDUtil.getId());
            esRole.setCreatetime(new Date());
            int flag = esRoleService.insertSelective(esRole);
            if(flag>0){
                return Result.success("更新成功");
            }
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
        return Result.fail("");
    }

    @DeleteMapping(value = "/deleteRole")
    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")
    public Result deleteMenu(String id){
        try{
            int flag = esRoleService.deleteByPrimaryKey(id);
            if(flag>0){
                return Result.success("删除成功");
            }
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
        return Result.fail("");
    }

    @GetMapping(value = "/getRole")
    @ApiOperation("获取角色")
    @ApiImplicitParam(name = "userName", value = "账号", required = true, dataType = "String")
    public Result getRole(String userName){
        List<EsRole> list = esRoleService.getRole(userName);
        return Result.success(list);
    }

    @GetMapping(value = "/getPermissionIds")
    @ApiOperation("获取资源")
    @ApiImplicitParam(name = "roleIds", value = "角色编码集合", required = true, dataType = "String")
    public Result getPermissionIds(String roleIds){
        List<Integer> list = esRoleService.getPermissionIds(roleIds);
        return Result.success(list);
    }
}
