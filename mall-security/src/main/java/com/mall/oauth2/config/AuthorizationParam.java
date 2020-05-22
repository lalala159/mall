package com.mall.oauth2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author HC
 * @Date 2020/5/22 17:40
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "authorizationparam")
public class AuthorizationParam {
    private String clientId; //客户端id
    private String secret; //(可信客户端需要)客户端密钥
    private String[] scopes; //客户受限范围
    private String authorizedGrantTypes; // 授权客户端使用的授权类型
    // private String authorities;//授予客户端的权限
    private int tokenExpire;//token过期时间
    private int tokenRefresh;//token 刷新时间
}
