package com.mall.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/8/4 17:08
 * @Version 1.0
 */
@Data
public class TreeVO {
    private Integer id;
    private String label;
    private Integer parentId;
}
