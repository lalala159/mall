package com.mall.info.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 门店信息(MallStore)实体类
 *
 * @author HC
 * @since 2020-07-22 16:49:41
 */
@Data
@ApiModel(value = "门店信息")
public class MallStore {
    /**
     * 门店编码
     */
    @ApiModelProperty(value = "门店编码")
    private Integer id;
    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;
    /**
     * 上级门店
     */
    @ApiModelProperty(value = "上级门店")
    private Integer parentId;
    /**
     * 注册日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "注册日期")
    private Date createDate;
    /**
     * 门店地址
     */
    @ApiModelProperty(value = "门店地址")
    private String address;
    /**
     * 门店联系电话
     */
    @ApiModelProperty(value = "门店联系电话")
    private String phone;
    /**
     * 门店负责人
     */
    @ApiModelProperty(value = "门店负责人")
    private String storeUser;
    /**
     * 门店状态：1正常0已禁用
     */
    @ApiModelProperty(value = "门店状态：1正常0已禁用")
    private Short valid;

}