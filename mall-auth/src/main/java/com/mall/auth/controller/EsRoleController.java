package com.mall.auth.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.EsRoleService;
import com.mall.common.domain.Member;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsRole;
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
public class EsRoleController {
    @Autowired
    private EsRoleService esRoleService;

    @GetMapping(value = "/queryList")
    public PageInfo queryList(Integer pageNum, Integer pageSize) {
        PageHelper.offsetPage(pageNum-1, pageSize);
        List<EsRole> list = esRoleService.queryList();
        return new PageInfo(list);
    }

    @PostMapping(value = "/addMenu")
    public Result addMenu(Integer roleId, String menuIds) {
        String[] menus = menuIds.split(",");
        int flag = esRoleService.addMenu(roleId, menus);
        return new Result(200, "设置成功");
    }

    @GetMapping(value = "/getPermissioned")
    public Result getPermissioned(Integer roleId) {
        List<Integer> list;
        if(roleId == null){
            list = null;
        }else{
            list = esRoleService.getPermissioned(roleId);
        }
        return new Result(200, "查询成功", list);
    }

    @PostMapping(value = "/addRole")
    public Result addRole(EsRole esRole) {
        try{
            esRole.setValid(true);
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
    public Result deleteMenu(Integer id){
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
    public Result getRole(String userName){
        List<EsRole> list = esRoleService.getRole(userName);
        return Result.success(list);
    }
}
