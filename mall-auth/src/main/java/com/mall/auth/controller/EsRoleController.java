package com.mall.auth.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.EsRoleService;
import com.mall.common.domain.Member;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.EsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(flag>0){
            return new Result(200, "设置成功");
        }
        return new Result(500, "设置失败");
    }
}
