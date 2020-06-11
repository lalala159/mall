package com.mall.auth.controller;


import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.MemberService;
import com.mall.auth.service.MyUserDetailService;
import com.mall.common.domain.EsMember;
import com.mall.common.domain.Member;
import com.mall.common.domain.Result;
import com.mall.common.enumeration.ResultCode;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 〈会员Controller〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/user")
public class MemberController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal member) {
        return member;
    }

    @DeleteMapping(value = "/exit")
    public Result revokeToken(String access_token) {
        Result result = new Result();
        if (consumerTokenServices.revokeToken(access_token)) {
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage("注销成功");
        } else {
            result.setCode(ResultCode.FAILED.getCode());
            result.setMessage("注销失败");
        }
        return result;
    }

    @PostMapping(value = "/queryList")
    public PageInfo queryList(Integer pageNum, Integer pageSize, String memberName, String mobile) {
        PageHelper.offsetPage(pageNum-1, pageSize);
        List<Member> list = memberService.queryList(memberName, mobile);
        return new PageInfo(list);
    }

    @PostMapping(value = "/addUser")
    public Result addUser(EsMember esMember) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("fj88888888");
        esMember.setPassword(password);
        try {
            esMember.setCreatetime(DateTime.now());
            memberService.insertSelective(esMember);
        }catch (DuplicateKeyException e){
            return new Result(888, "该账号已存在");
        }

        return new Result(200, "新增成功");
    }

    @DeleteMapping(value = "/deleteUser")
    public Result deleteUser(Integer id){
        try{
            memberService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return new Result(200, "删除失败");
        }
        return new Result(200, "删除成功");
    }
}
