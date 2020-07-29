package com.mall.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.api.domain.EsMember;
import com.mall.api.service.EsMemberServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esMember")
@Api(tags = "")
public class EsMemberController {

    @Autowired
    private EsMemberServiceI esMemberService;

    @GetMapping("/get/{id}")
    @ApiOperation("根据ID查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true)
    })
    public EsMember getById(@PathVariable String id) {
        EsMember esMember = esMemberService.getById(id);
        return esMember != null ? esMember : new EsMember();
    }

    @GetMapping("/get")
    @ApiOperation("根据条件查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "esMember", value = "", dataType = "EsMember")
    })
    public EsMember getByEntity(EsMember esMember) {
        return esMemberService.getByEntity(esMember);
    }

    @GetMapping("/list")
    @ApiOperation("根据条件查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "esMember", value = "", dataType = "EsMember")
    })
    public List<EsMember> list(EsMember esMember) {
        List<EsMember> esMemberList = esMemberService.listByEntity(esMember);
        return esMemberList;
    }

    @PostMapping("/queryList")
    @ApiOperation("分页查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "esMember", value = "", dataType = "EsMember")
    })
    public PageInfo queryList(Integer pageNum, Integer pageSize, EsMember esMember) {
        PageHelper.startPage(pageNum, pageSize);
        List<EsMember> list = esMemberService.listByEntity(esMember);
        return new PageInfo(list);
    }

    @PostMapping("/insert")
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "esMember", value = "", dataType = "EsMember")
    })
    public EsMember insert(@RequestBody EsMember esMember) {
        esMemberService.insert(esMember);
        return esMember;
    }

    @PutMapping("/update")
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "esMember", value = "", dataType = "EsMember")
    })
    public int update(@RequestBody EsMember esMember) {
        return esMemberService.update(esMember);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键")
    })
    public int deleteOne(@PathVariable String id) {
        return esMemberService.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ApiOperation("批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键集合")
    })
    public int deleteBatch(@RequestBody List<String> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = esMemberService.deleteByIds(ids);
        }
        return result;
    }

}