package com.mall.common.domain.auth;

import lombok.Data;

/**
 * @Author HC
 * @Date 2020/6/24 15:24
 * @Version 1.0
 */
@Data
public class UserRole {
    private int id;
    private String roleId;
    private String memberId;
}
