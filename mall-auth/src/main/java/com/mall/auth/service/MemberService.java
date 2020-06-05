package com.mall.auth.service;

import com.mall.auth.dao.MemberDao;
import com.mall.common.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/5 15:22
 * @Version 1.0
 */
@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public List<Member> queryList(String memberName, String mobile){
        return memberDao.queryList(memberName, mobile);
    }
}
