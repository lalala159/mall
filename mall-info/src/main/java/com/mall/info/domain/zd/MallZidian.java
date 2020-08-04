package com.mall.info.domain.zd;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 字典信息表(MallZidian)实体类
 *
 * @author HC
 * @since 2020-08-04 16:35:49
 */
@Data
@ApiModel(value = "字典信息表")
public class MallZidian {
    /**
     * 主键编码
     */
    @ApiModelProperty(value = "主键编码")
    private Integer id;
    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    private String zdCode;
    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String zdmc;
    /**
     * 上级编码
     */
    @ApiModelProperty(value = "上级编码")
    private Integer pId;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createDate;
    /**
     * 更新日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

}