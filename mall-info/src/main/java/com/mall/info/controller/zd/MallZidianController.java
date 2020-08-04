package com.mall.info.controller.zd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.domain.Result;
import com.mall.common.domain.TreeList;
import com.mall.common.domain.TreeVO;
import com.mall.common.util.TreeUtils;
import com.mall.info.domain.zd.MallZidian;
import com.mall.info.service.zd.MallZidianServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.Tree;

import java.util.List;

@RestController
@RequestMapping("/mallZidian")
@Api(tags = "字典信息表")
public class MallZidianController {

    @Autowired
    private MallZidianServiceI mallZidianService;

    @GetMapping("/get/{id}")
    @ApiOperation("根据ID查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true)
    })
    public MallZidian getById(@PathVariable Integer id) {
        MallZidian mallZidian = mallZidianService.getById(id);
        return mallZidian != null ? mallZidian : new MallZidian();
    }

    @GetMapping("/get")
    @ApiOperation("根据条件查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallZidian", value = "字典信息表", dataType = "MallZidian")
    })
    public MallZidian getByEntity(MallZidian mallZidian) {
        return mallZidianService.getByEntity(mallZidian);
    }

    @GetMapping("/list")
    @ApiOperation("根据条件查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallZidian", value = "字典信息表", dataType = "MallZidian")
    })
    public Result list(MallZidian mallZidian) {
        List<TreeVO> treeVOS = mallZidianService.getTreeList();
        List<TreeList> treeLists = TreeUtils.getTree(treeVOS);
        return Result.success(treeLists);
    }

    @PostMapping("/queryList")
    @ApiOperation("分页查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "mallZidian", value = "字典信息表", dataType = "MallZidian")
    })
    public PageInfo queryList(Integer pageNum, Integer pageSize, MallZidian mallZidian) {
        PageHelper.startPage(pageNum, pageSize);
        List<MallZidian> list = mallZidianService.listByEntity(mallZidian);
        return new PageInfo(list);
    }

    @PostMapping("/insert")
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallZidian", value = "字典信息表", dataType = "MallZidian")
    })
    public MallZidian insert(MallZidian mallZidian) {
        mallZidianService.insert(mallZidian);
        return mallZidian;
    }

    @PutMapping("/update")
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallZidian", value = "字典信息表", dataType = "MallZidian")
    })
    public int update(@RequestBody MallZidian mallZidian) {
        return mallZidianService.update(mallZidian);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键")
    })
    public int deleteOne(@PathVariable Integer id) {
        return mallZidianService.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ApiOperation("批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键集合")
    })
    public int deleteBatch(@RequestBody List<Integer> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = mallZidianService.deleteByIds(ids);
        }
        return result;
    }

}