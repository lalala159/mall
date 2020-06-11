package com.mall.auth.service;

import com.mall.auth.dao.EsPermissionDao;
import com.mall.common.domain.auth.EsPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HC
 * @Date 2020/6/11 15:42
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames="permission")
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

    @Cacheable
    public  List<Map<String, Object>> getUserInfo(String userName){
        List<EsPermission> list = esPermissionDao.getUserInfo(userName);
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (EsPermission esPermission : list) {
            if(esPermission.getParentId() == 0){
                Map<String, Object> map = new HashMap<>();
                map.put("path", esPermission.getUrl());
                List<Map<String, Object>> cList = new ArrayList<>();
                for (EsPermission permission : list) {
                    if(esPermission.getId() == permission.getParentId()){
                        Map<String, Object> cmap = new HashMap<>();
                        cmap.put("path", permission.getUrl());
                        cList.add(cmap);
                    }
                }
                map.put("children", cList);
                listMap.add(map);
            }
        }
        return listMap;
    }
}
