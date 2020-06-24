package com.mall.auth.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Author HC
 * @Date 2020/6/12 17:30
 * @Version 1.0
 */
@Data
public class Menu implements Serializable {
    private String id;
    private String title;
    private String icon;
    private String key;
    private String path;
    private List<Menu> children;
}

