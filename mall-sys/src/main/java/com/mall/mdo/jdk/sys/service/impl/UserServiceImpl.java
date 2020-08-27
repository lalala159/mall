package com.mall.mdo.jdk.sys.service.impl;


import com.mall.mdo.jdk.sys.service.UserService;
import com.mall.mdo.jdk.sys.dao.JkglUserDao;
import com.mall.mdo.jdk.sys.domain.JkglUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author HC
 * @Date 2020/5/20 13:41
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames="user")
public class UserServiceImpl implements UserService {

    @Autowired
    private JkglUserDao jkglUserDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(JkglUser record) {
        return 0;
    }

    @Override
    public int insertSelective(JkglUser record) {
        return 0;
    }

    @Cacheable
    @Override
    public JkglUser selectByPrimaryKey(Integer id) {
        return jkglUserDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JkglUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(JkglUser record) {
        return 0;
    }
}
