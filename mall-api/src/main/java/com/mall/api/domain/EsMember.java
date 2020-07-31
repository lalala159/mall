package com.mall.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (EsMember)实体类
 *
 * @author HC
 * @since 2020-07-29 10:52:13
 */
@Data
@ApiModel(value = "人员信息")
public class EsMember {
    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    private String id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 会员名
     */
    @ApiModelProperty(value = "会员名")
    private String memberName;
    /**
     * 门店编码
     */
    @ApiModelProperty(value = "门店编码")
    private Integer storeId;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    /**
     * 性别 1男0女
     */
    @ApiModelProperty(value = "性别 1男0女")
    private Short sex;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 出生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出生日")
    private Date birthday;
    /**
     * 注册日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "注册日期")
    private Date createtime;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "微信头像")
    private String wxImg;

    @ApiModelProperty(value = "微信昵称")
    private String wxNickname;

    @ApiModelProperty(value = "token")
    private String token;

}