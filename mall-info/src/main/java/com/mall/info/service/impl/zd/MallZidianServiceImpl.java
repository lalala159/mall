package com.mall.info.service.impl.zd;

import com.mall.common.domain.TreeVO;
import com.mall.info.dao.zd.MallZidianDao;
import com.mall.info.domain.zd.MallZidian;
import com.mall.info.service.zd.MallZidianServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallZidianServiceImpl implements MallZidianServiceI {

    @Autowired
    private MallZidianDao mallZidianDao;

    @Override
    public MallZidianDao getMallZidianDao() {
        return mallZidianDao;
    }

    @Override
    public MallZidian getById(Integer id) {
        return mallZidianDao.getById(id);
    }

    @Override
    public MallZidian getByEntity(MallZidian mallZidian) {
        return mallZidianDao.getByEntity(mallZidian);
    }

    @Override
    public List<MallZidian> listByEntity(MallZidian mallZidian) {
        return mallZidianDao.listByEntity(mallZidian);
    }

    @Override
    public List<MallZidian> listByIds(List<Integer> ids) {
        return mallZidianDao.listByIds(ids);
    }

    @Override
    public int insert(MallZidian mallZidian) {
        return mallZidianDao.insert(mallZidian);
    }

    @Override
    public int insertBatch(List<MallZidian> list) {
        return mallZidianDao.insertBatch(list);
    }

    @Override
    public int update(MallZidian mallZidian) {
        return mallZidianDao.update(mallZidian);
    }

    @Override
    public int updateBatch(List<MallZidian> list) {
        return mallZidianDao.updateBatch(list);
    }

    @Override
    public int deleteById(Integer id) {
        return mallZidianDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(MallZidian mallZidian) {
        return mallZidianDao.deleteByEntity(mallZidian);
    }

    @Override
    public int deleteByIds(List<Integer> list) {
        return mallZidianDao.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return mallZidianDao.countAll();
    }

    @Override
    public int countByEntity(MallZidian mallZidian) {
        return mallZidianDao.countByEntity(mallZidian);
    }

    @Override
    public List<TreeVO> getTreeList() {
        return mallZidianDao.getTreeList();
    }

}