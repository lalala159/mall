package com.mall.sys.service;

import com.mall.sys.domain.JkglUser;

/**
 * @Author HC
 * @Date 2020/5/20 13:47
 * @Version 1.0
 */
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(JkglUser record);

    int insertSelective(JkglUser record);

    JkglUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JkglUser record);

    int updateByPrimaryKey(JkglUser record);
}
