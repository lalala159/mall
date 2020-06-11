package com.mall.auth.service;

import com.mall.auth.dao.EsPermissionDao;
import com.mall.common.domain.auth.EsPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author HC
 * @Date 2020/6/11 15:42
 * @Version 1.0
 */
@Service
public class EsPermissionService {
    @Autowired
    private EsPermissionDao esPermissionDao;

    public int deleteByPrimaryKey(Integer id){
        return esPermissionDao.deleteByPrimaryKey(id);
    }

    public int insert(EsPermission record){
        return esPermissionDao.insert(record);
    }

    public int insertSelective(EsPermission record){
        return esPermissionDao.insertSelective(record);
    }

    public EsPermission selectByPrimaryKey(Integer id){
        return esPermissionDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EsPermission record){
        return esPermissionDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EsPermission record){
        return esPermissionDao.updateByPrimaryKey(record);
    }
}
