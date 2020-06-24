package com.mall.auth.dao;

import com.mall.common.domain.auth.EsRole;
import com.mall.common.domain.auth.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EsRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(EsRole record);

    int insertSelective(EsRole record);

    EsRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EsRole record);

    int updateByPrimaryKey(EsRole record);

    List<EsRole> queryList();

    int addMenu(RolePermission rolePermission);

    int deleMenu(String roleId);


    List<Integer> getPermissioned(@Param(value = "roleId") String roleId);

    List<EsRole> getRole(@Param(value = "userName") String userName);

    List<EsRole> getAllRole();

    List<Integer> getPermissionIds(@Param(value = "roleIds") String roleIds);
}