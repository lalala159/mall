package com.mall.auth.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.MemberService;
import com.mall.auth.service.MyUserDetailService;
import com.mall.common.domain.Member;
import com.mall.common.domain.Result;
import com.mall.common.enumeration.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
}
