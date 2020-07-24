package com.mall.common.domain.auth;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * es_role
 * @author 
 */
@Data
@ApiModel("角色")
public class EsRole implements Serializable {
    /**
     * 角色id
     */
    @ApiModelProperty("主键")
    private String id;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;

    /**
     * 是否有效 1是 0否
     */
    @ApiModelProperty("是否有效 1是 0否")
    private Boolean valid;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期", dataType="java.util.Date")
    private Date createtime;

    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期", dataType="java.util.Date")
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}