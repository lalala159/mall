package com.mall.info.controller.sp;

import com.mall.common.domain.Result;
import com.mall.common.domain.TreeList;
import com.mall.common.domain.sp.MallSplxInfo;
import com.mall.info.service.sp.MallSplxInfoService;
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
public class MallSplxInfoController {
    @Autowired
    private MallSplxInfoService mallSplxInfoService;

    @DeleteMapping(value = "/lx/delete")
    public Result deleteLx(Integer id){
        mallSplxInfoService.deleteByPrimaryKey(id);
        return Result.success("删除成功");
    }

    @GetMapping(value = "/lx/queryList")
    public Result queryLxList(){
        List<TreeList> list = mallSplxInfoService.queryLxList();
        return Result.success(list);
    }

    @PostMapping(value = "/lx/add")
    public Result addLx(MallSplxInfo mallSplxInfo){
        mallSplxInfoService.insertSelective(mallSplxInfo);
        return Result.success("新增成功");
    }

    @PostMapping(value = "/lx/edit")
    public Result editLx(MallSplxInfo mallSplxInfo){
        mallSplxInfoService.updateByPrimaryKeySelective(mallSplxInfo);
        return Result.success("修改成功");
    }
}
