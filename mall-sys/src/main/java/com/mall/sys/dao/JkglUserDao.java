package com.mall.sys.dao;

import com.mall.sys.domain.JkglUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JkglUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JkglUser record);

    int insertSelective(JkglUser record);

    JkglUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JkglUser record);

    int updateByPrimaryKey(JkglUser record);
}