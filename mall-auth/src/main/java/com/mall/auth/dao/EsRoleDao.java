package com.mall.auth.dao;

import com.mall.common.domain.auth.EsRole;
import com.mall.common.domain.auth.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EsRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EsRole record);

    int insertSelective(EsRole record);

    EsRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EsRole record);

    int updateByPrimaryKey(EsRole record);

    List<EsRole> queryList();

    int addMenu(RolePermission rolePermission);

    int deleMenu(Integer roleId);
}