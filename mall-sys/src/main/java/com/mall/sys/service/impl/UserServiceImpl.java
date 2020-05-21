package com.mall.sys.service.impl;


import com.mall.sys.dao.JkglUserDao;
import com.mall.sys.domain.JkglUser;
import com.mall.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author HC
 * @Date 2020/5/20 13:41
 * @Version 1.0
 */
@Service
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
