package com.mall.info.controller.sp;

import com.mall.common.domain.Result;
import com.mall.common.domain.TreeList;
import com.mall.common.domain.sp.MallSplxInfo;
import com.mall.info.service.sp.MallSplxInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/7/7 17:28
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "sp")
@Api(tags = "商品类型管理")
public class MallSplxInfoController {
    @Autowired
    private MallSplxInfoService mallSplxInfoService;

    @DeleteMapping(value = "/lx/delete")
    @ApiOperation("删除类型")
    @ApiImplicitParam(name = "id", value = "主键", dataType = "Integer", required = true)
    public Result deleteLx(Integer id){
        mallSplxInfoService.deleteByPrimaryKey(id);
        return Result.success("删除成功");
    }

    @GetMapping(value = "/lx/queryList")
    @ApiOperation("查询类型")
    public Result queryLxList(){
        List<TreeList> list = mallSplxInfoService.queryLxList();
        return Result.success(list);
    }

    @PostMapping(value = "/lx/add")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "mallSplxInfo", value = "类型", dataType = "MallSplxInfo")
    public Result addLx(MallSplxInfo mallSplxInfo){
        mallSplxInfoService.insertSelective(mallSplxInfo);
        return Result.success("新增成功");
    }

    @PostMapping(value = "/lx/edit")
    @ApiOperation("编辑")
    @ApiImplicitParam(name = "mallSplxInfo", value = "类型", dataType = "MallSplxInfo")
    public Result editLx(MallSplxInfo mallSplxInfo){
        mallSplxInfoService.updateByPrimaryKeySelective(mallSplxInfo);
        return Result.success("修改成功");
    }
}
