package com.mall.common.domain.sp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * mall_splx_info
 * @author 
 */
@Data
@ApiModel("商品类型")
public class MallSplxInfo implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 商品类型名称
     */
    @ApiModelProperty(value = "商品类型名称")
    private String lxMc;

    /**
     * 上级编码
     */
    @ApiModelProperty(value = "上级编码")
    private Integer parentId;

    /**
     * 类型图标
     */
    @ApiModelProperty(value = "类型图标")
    private String icon;

    private static final long serialVersionUID = 1L;
}