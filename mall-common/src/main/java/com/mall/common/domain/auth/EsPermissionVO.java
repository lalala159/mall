package com.mall.common.domain.auth;

import lombok.Data;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/11 16:02
 * @Version 1.0
 */
@Data
public class EsPermissionVO extends EsPermission{
    private List<EsPermission> list;
}
