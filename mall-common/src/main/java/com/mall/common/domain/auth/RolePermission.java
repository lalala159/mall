package com.mall.common.domain.auth;

import lombok.Data;

/**
 * @Author HC
 * @Date 2020/6/18 16:04
 * @Version 1.0
 */
@Data
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
}
