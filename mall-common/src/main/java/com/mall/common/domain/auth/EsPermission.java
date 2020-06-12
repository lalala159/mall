package com.mall.common.domain.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * es_permission
 * @author 
 */
@Data
public class EsPermission implements Serializable {
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String permissionName;

    /**
     * 上级编码
     */
    private Integer parentId;

    /**
     * 路由
     */
    private String url;

    /**
     * 图标
     */
    private String icon;


    /**
     * 组件地址
     */
    private String component;


    /**
     * 方法类型
     */
    private String method;

    /**
     * 网关前缀
     */
    private String zuulPrefix;

    /**
     * 服务前缀
     */
    private String servicePrefix;

    /**
     * 请求路径
     */
    private String uri;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 更新日期
     */
    private Date updatetime;

    private Integer ranks;

    private static final long serialVersionUID = 1L;
}