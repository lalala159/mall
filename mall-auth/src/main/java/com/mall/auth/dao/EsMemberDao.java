package com.mall.auth.dao;


import com.mall.common.domain.EsMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EsMemberDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EsMember record);

    int insertSelective(EsMember record);

    EsMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EsMember record);

    int updateByPrimaryKey(EsMember record);
}