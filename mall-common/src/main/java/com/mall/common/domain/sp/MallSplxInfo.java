package com.mall.common.domain.sp;

import lombok.Data;

import java.io.Serializable;

/**
 * mall_splx_info
 * @author 
 */
@Data
public class MallSplxInfo implements Serializable {
    private Integer id;

    /**
     * 商品类型名称
     */
    private String lxMc;

    /**
     * 上级编码
     */
    private Integer parentId;

    /**
     * 类型图标
     */
    private String icon;

    private static final long serialVersionUID = 1L;
}