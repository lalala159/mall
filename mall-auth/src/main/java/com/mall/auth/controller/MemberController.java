package com.mall.auth.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.auth.service.MemberService;
import com.mall.auth.service.MyUserDetailService;
import com.mall.auth.util.UUIDUtil;
import com.mall.common.domain.EsMember;
import com.mall.common.domain.Member;
import com.mall.common.domain.Result;
import com.mall.common.domain.auth.UserRole;
import com.mall.common.enumeration.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
@Slf4j
@Api(tags = "用户管理")
public class MemberController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    @ApiOperation("获取用户信息")
    public Principal user(Principal member) {
        return member;
    }

    @DeleteMapping(value = "/exit")
    @ApiOperation("注销")
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
    @ApiOperation("查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "memberName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String"),

    })
    public PageInfo queryList(Integer pageNum, Integer pageSize, String memberName, String mobile) {
        PageHelper.startPage(pageNum, pageSize);
        List<Member> list = memberService.queryList(memberName, mobile);
        return new PageInfo(list);
    }

    @PostMapping(value = "/addUser")
    @ApiOperation("新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "esMember", value = "用户信息", dataType = "EsMember"),
            @ApiImplicitParam(name = "roleIds", value = "角色编码集合", dataType = "String")
    })
    public Result addUser(EsMember esMember, String roleIds) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("fj88888888");
        String memberId = UUIDUtil.getId();
        esMember.setId(memberId);
        esMember.setPassword(password);
        String[] roleId = roleIds.split(",");
        try {
            esMember.setCreatetime(new Date());
            memberService.insertSelective(esMember);
            for (String s : roleId) {
                UserRole userRole = new UserRole();
                userRole.setMemberId(memberId);
                userRole.setRoleId(s);
                memberService.addRole(userRole);
            }
        }catch (DuplicateKeyException e){
            return new Result(888, "该账号已存在");
        }

        return new Result(200, "新增成功");
    }

    @DeleteMapping(value = "/deleteUser")
    @ApiOperation("删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除用户", dataType = "String")
    })
    public Result deleteUser(String id){
        try{
            memberService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return new Result(200, "删除失败");
        }
        return new Result(200, "删除成功");
    }
}
