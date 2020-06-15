package com.mall.common.domain.auth;

import lombok.Data;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/15 11:23
 * @Version 1.0
 */
@Data
public class MenuVO {
    private Integer id;
    private String label;
    List<MenuVO> children;
}
