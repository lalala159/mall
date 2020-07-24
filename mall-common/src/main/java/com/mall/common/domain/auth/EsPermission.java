package com.mall.common.domain.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * es_permission
 * @author 
 */
@Data
@Api("资源信息")
public class EsPermission implements Serializable {
    /**
     * 权限id
     */
    @ApiModelProperty("主键")
    private String id;

    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    private String permissionName;

    /**
     * 上级
     * 编码
     */
    @ApiModelProperty("上级编码")
    private String parentId;

    /**
     * 路由
     */
    @ApiModelProperty("路由")
    private String url;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;


    /**
     * 组件地址
     */
    @ApiModelProperty("组件地址")
    private String component;


    /**
     * 方法类型
     */
    @ApiModelProperty("方法类型")
    private String method;

    /**
     * 网关前缀
     */
    @ApiModelProperty("网关前缀")
    private String zuulPrefix;

    /**
     * 服务前缀
     */
    @ApiModelProperty("服务前缀")
    private String servicePrefix;

    /**
     * 请求路径
     */
    @ApiModelProperty("服务前缀")
    private String uri;

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

    @ApiModelProperty(value = "排序")
    private Integer ranks;


    private static final long serialVersionUID = 1L;
}