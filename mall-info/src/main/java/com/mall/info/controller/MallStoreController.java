package com.mall.info.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.info.domain.MallStore;
import com.mall.info.service.MallStoreServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mallStore")
@Api(tags = "门店信息")
public class MallStoreController {

    @Autowired
    private MallStoreServiceI mallStoreService;

    @GetMapping("/get/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true)
    })
    @ApiOperation("根据id获取信息")
    public MallStore getById(@PathVariable Integer id) {
        MallStore mallStore = mallStoreService.getById(id);
        return mallStore != null ? mallStore : new MallStore();
    }

    @GetMapping("/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallStore", value = "MallStore", dataType = "MallStore")
    })
    public MallStore getByEntity(MallStore mallStore) {
        return mallStoreService.getByEntity(mallStore);
    }

    @GetMapping("/list")
    public List<MallStore> list(MallStore mallStore) {
        List<MallStore> mallStoreList = mallStoreService.listByEntity(mallStore);
        return mallStoreList;
    }

    @PostMapping("/queryList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "当前大小", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "mallStore", value = "门店信息", dataType = "MallStore"),
    })
    public PageInfo queryList(Integer pageNum, Integer pageSize, MallStore mallStore) {
        PageHelper.startPage(pageNum, pageSize);
        List<MallStore> list = mallStoreService.listByEntity(mallStore);
        return new PageInfo(list);
    }

    @PostMapping("/insert")
    public MallStore insert(@RequestBody MallStore mallStore) {
        mallStoreService.insert(mallStore);
        return mallStore;
    }

    @PutMapping("/update")
    public int update(@RequestBody MallStore mallStore) {
        return mallStoreService.update(mallStore);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteOne(@PathVariable Integer id) {
        return mallStoreService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public int deleteBatch(@RequestBody List<Integer> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = mallStoreService.deleteByIds(ids);
        }
        return result;
    }

}