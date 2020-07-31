package com.mall.api.service.impl;

import com.mall.api.dao.EsMemberDao;
import com.mall.api.domain.EsMember;
import com.mall.api.service.EsMemberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EsMemberServiceImpl implements EsMemberServiceI {

    @Autowired
    private EsMemberDao esMemberDao;

    @Override
    public EsMemberDao getEsMemberDao() {
        return esMemberDao;
    }

    @Override
    public EsMember getById(String id) {
        return esMemberDao.getById(id);
    }

    @Override
    public EsMember getByEntity(EsMember esMember) {
        return esMemberDao.getByEntity(esMember);
    }

    @Override
    public List<EsMember> listByEntity(EsMember esMember) {
        return esMemberDao.listByEntity(esMember);
    }

    @Override
    public List<EsMember> listByIds(List<String> ids) {
        return esMemberDao.listByIds(ids);
    }

    @Override
    public int insert(EsMember esMember) {
        return esMemberDao.insert(esMember);
    }

    @Override
    public int insertBatch(List<EsMember> list) {
        return esMemberDao.insertBatch(list);
    }

    @Override
    public int update(EsMember esMember) {
        return esMemberDao.update(esMember);
    }

    @Override
    public int updateBatch(List<EsMember> list) {
        return esMemberDao.updateBatch(list);
    }

    @Override
    public int deleteById(String id) {
        return esMemberDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(EsMember esMember) {
        return esMemberDao.deleteByEntity(esMember);
    }

    @Override
    public int deleteByIds(List<String> list) {
        return esMemberDao.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return esMemberDao.countAll();
    }

    @Override
    public int countByEntity(EsMember esMember) {
        return esMemberDao.countByEntity(esMember);
    }

    @Override
    public EsMember getMemberByOpenId(String openId) {
        return esMemberDao.getMemberByOpenId(openId);
    }

}