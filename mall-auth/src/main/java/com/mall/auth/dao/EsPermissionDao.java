package com.mall.auth.dao;

import com.mall.common.domain.auth.EsPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EsPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EsPermission record);

    int insertSelective(EsPermission record);

    EsPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EsPermission record);

    int updateByPrimaryKey(EsPermission record);

    List<EsPermission> getUserInfo(String UserName);


}