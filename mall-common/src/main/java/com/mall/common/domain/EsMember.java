package com.mall.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * es_member
 * @author 
 */
@Data
@ApiModel("用户信息")
public class EsMember implements Serializable {
    /**
     * 会员id
     */
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 会员名
     */
    @ApiModelProperty("会员名")
    private String memberName;

    /**
     * 所属门店
     */
    @ApiModelProperty("所属门店")
    private Integer storeId;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

    /**
     * 性别 1男0女
     */
    @ApiModelProperty("性别 1男0女")
    private Boolean sex;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 出生日
     */
    @ApiModelProperty(value = "出生日", dataType="java.util.Date")
    private Date birthday;

    /**
     * 注册日期
     */
    @ApiModelProperty(value = "注册日期", dataType="java.util.Date")
    private Date createtime;

    private static final long serialVersionUID = 1L;
}