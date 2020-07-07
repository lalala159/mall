package com.mall.common.domain;

import com.mall.common.domain.auth.MenuVO;
import lombok.Data;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/7/7 17:37
 * @Version 1.0
 */
@Data
public class TreeList {
    private String id;
    private String label;
    List<TreeList> children;
}
