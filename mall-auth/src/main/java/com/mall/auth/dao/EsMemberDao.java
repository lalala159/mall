package com.mall.auth.dao;


import com.mall.common.domain.EsMember;
import com.mall.common.domain.auth.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EsMemberDao {
    int deleteByPrimaryKey(String id);

    int insert(EsMember record);

    int insertSelective(EsMember record);

    EsMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EsMember record);

    int updateByPrimaryKey(EsMember record);

    int addRole(UserRole userRole);
}