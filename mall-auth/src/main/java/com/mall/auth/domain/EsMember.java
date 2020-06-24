package com.mall.auth.domain;

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
    private String id;

    /**
     * 会员名
     */
    private String memberName;

    /**
     * 账号
     */
    private String userName;

    /**
     * 门店编码
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