package com.mall.info.service;

import com.mall.info.dao.MallStoreDao;
import com.mall.info.domain.MallStore;

import java.util.List;

public interface MallStoreServiceI {

    MallStoreDao getMallStoreDao();

    MallStore getById(Integer id);

    MallStore getByEntity(MallStore mallStore);

    List<MallStore> listByEntity(MallStore mallStore);

    List<MallStore> listByIds(List<Integer> ids);

    int insert(MallStore mallStore);

    int insertBatch(List<MallStore> list);

    int update(MallStore mallStore);

    int updateBatch(List<MallStore> list);

    int deleteById(Integer id);

    int deleteByEntity(MallStore mallStore);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(MallStore mallStore);
}