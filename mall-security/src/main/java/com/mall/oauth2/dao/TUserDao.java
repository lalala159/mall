package com.mall.oauth2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.oauth2.domain.TUser;

public interface TUserDao extends BaseMapper<TUser> {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}