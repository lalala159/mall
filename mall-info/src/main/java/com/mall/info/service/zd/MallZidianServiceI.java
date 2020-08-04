package com.mall.info.service.zd;

import com.mall.common.domain.TreeVO;
import com.mall.info.dao.zd.MallZidianDao;
import com.mall.info.domain.zd.MallZidian;

import java.util.List;

public interface MallZidianServiceI {

    MallZidianDao getMallZidianDao();

    MallZidian getById(Integer id);

    MallZidian getByEntity(MallZidian mallZidian);

    List<MallZidian> listByEntity(MallZidian mallZidian);

    List<MallZidian> listByIds(List<Integer> ids);

    int insert(MallZidian mallZidian);

    int insertBatch(List<MallZidian> list);

    int update(MallZidian mallZidian);

    int updateBatch(List<MallZidian> list);

    int deleteById(Integer id);

    int deleteByEntity(MallZidian mallZidian);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(MallZidian mallZidian);

    public List<TreeVO> getTreeList();
}