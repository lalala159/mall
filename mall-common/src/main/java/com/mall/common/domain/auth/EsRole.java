package com.mall.common.domain.auth;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * es_role
 * @author 
 */
@Data
public class EsRole implements Serializable {
    /**
     * 角色id
     */
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 是否有效 1是 0否
     */
    private Boolean valid;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 更新日期
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}