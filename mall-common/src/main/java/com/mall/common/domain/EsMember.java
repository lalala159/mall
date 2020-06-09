package com.mall.common.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * es_member
 * @author 
 */
@Data
public class EsMember implements Serializable {
    /**
     * 会员id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 会员名
     */
    private String memberName;

    /**
     * 所属门店
     */
    private Integer storeId;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 性别 1男0女
     */
    private Boolean sex;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 出生日
     */
    private Date birthday;

    /**
     * 注册日期
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}