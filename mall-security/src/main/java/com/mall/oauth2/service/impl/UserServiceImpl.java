package com.mall.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.oauth2.authbean.AuthUserDetail;
import com.mall.oauth2.dao.TUserDao;
import com.mall.oauth2.domain.TUser;
import com.mall.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserDao tUserMapper;

    @Override
    public AuthUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser tUser = tUserMapper.selectByPrimaryKey(username);
        if(tUser==null){
            throw new UsernameNotFoundException("用户不存在");
        }else{
            return UserDetailConverter.convert(tUser);
        }
    }
    private static class UserDetailConverter {
        static AuthUserDetail convert(TUser user) {
            return new AuthUserDetail(user);
        }
    }
}
