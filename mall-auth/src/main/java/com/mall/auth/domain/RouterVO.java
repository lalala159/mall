package com.mall.auth.domain;

import lombok.Data;

/**
 * @Author HC
 * @Date 2020/6/12 17:31
 * @Version 1.0
 */
@Data
public class RouterVO {
    /**
     * 名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * 组件
     */
    private String component;
}

