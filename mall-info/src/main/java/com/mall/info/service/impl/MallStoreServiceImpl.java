package com.mall.info.service.impl;

import com.mall.info.dao.MallStoreDao;
import com.mall.info.domain.MallStore;
import com.mall.info.service.MallStoreServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallStoreServiceImpl implements MallStoreServiceI {

    @Autowired
    private MallStoreDao mallStoreDao;

    @Override
    public MallStoreDao getMallStoreDao() {
        return mallStoreDao;
    }

    @Override
    public MallStore getById(Integer id) {
        return mallStoreDao.getById(id);
    }

    @Override
    public MallStore getByEntity(MallStore mallStore) {
        return mallStoreDao.getByEntity(mallStore);
    }

    @Override
    public List<MallStore> listByEntity(MallStore mallStore) {
        return mallStoreDao.listByEntity(mallStore);
    }

    @Override
    public List<MallStore> listByIds(List<Integer> ids) {
        return mallStoreDao.listByIds(ids);
    }

    @Override
    public int insert(MallStore mallStore) {
        return mallStoreDao.insert(mallStore);
    }

    @Override
    public int insertBatch(List<MallStore> list) {
        return mallStoreDao.insertBatch(list);
    }

    @Override
    public int update(MallStore mallStore) {
        return mallStoreDao.update(mallStore);
    }

    @Override
    public int updateBatch(List<MallStore> list) {
        return mallStoreDao.updateBatch(list);
    }

    @Override
    public int deleteById(Integer id) {
        return mallStoreDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(MallStore mallStore) {
        return mallStoreDao.deleteByEntity(mallStore);
    }

    @Override
    public int deleteByIds(List<Integer> list) {
        return mallStoreDao.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return mallStoreDao.countAll();
    }

    @Override
    public int countByEntity(MallStore mallStore) {
        return mallStoreDao.countByEntity(mallStore);
    }

}