package com.mall.auth.domain;

import lombok.Data;

import java.util.Set;

/**
 * @Author HC
 * @Date 2020/6/12 17:30
 * @Version 1.0
 */
@Data
public class Menu {
    private Integer id;
    private String title;
    private String icon;
    private String key;
    private String path;
    private Set<Menu> children;
}

