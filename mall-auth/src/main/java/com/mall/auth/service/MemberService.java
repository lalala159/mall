package com.mall.auth.service;

import com.mall.auth.dao.EsMemberDao;
import com.mall.auth.dao.MemberDao;
import com.mall.common.domain.EsMember;
import com.mall.common.domain.Member;
import com.mall.common.domain.auth.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/5 15:22
 * @Version 1.0
 */
@Service
@Slf4j
public class MemberService {

    @Autowired
    private EsMemberDao memberDao;

    @Autowired
    private MemberDao esmemberDao;

    public int deleteByPrimaryKey(String id){
        return memberDao.deleteByPrimaryKey(id);
    }

    public int insert(EsMember record){
        return memberDao.insert(record);
    }

    public int insertSelective(EsMember record){
        return memberDao.insertSelective(record);
    }

    public EsMember selectByPrimaryKey(String id){
        return memberDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EsMember record){
        return memberDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EsMember record){
        return memberDao.updateByPrimaryKey(record);
    }

    public List<Member> queryList(String memberName, String mobile){
        return esmemberDao.queryList(memberName, mobile);
    }

    public int addRole(UserRole userRole){
        try{
            return memberDao.addRole(userRole);
        }catch (Exception e){
            log.error(e.getMessage());
            return 0;
        }
    }
}
