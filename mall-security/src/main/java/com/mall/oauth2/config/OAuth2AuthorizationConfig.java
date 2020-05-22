package com.mall.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
/***
 * OAuth 相关配置
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    private static final String SECRETPREFIX = "{noop}"; //spring security5 之后需要
    @Autowired
    private AuthenticationManager authenticationManager; //认证管理者
    @Autowired
    private UserDetailsService userDetailsService; // 用户信息服务
    @Autowired
    private TokenStore tokenStore; //保存令牌数据栈
    @Autowired
    private AuthorizationParam authorizationParam;
    @Override
    public void configure(ClientDetailsServiceConfigurer clents) throws Exception {
        clents.inMemory()
                .withClient(authorizationParam.getClientId()) //客户端ID
                .authorizedGrantTypes(authorizationParam.getAuthorizedGrantTypes(),"refresh_token")//设置验证方式
                .scopes(authorizationParam.getScopes())
                // .secret("{noop}secret")
                .secret(SECRETPREFIX+authorizationParam.getSecret())
                .accessTokenValiditySeconds(authorizationParam.getTokenExpire()) //token过期时间
                .refreshTokenValiditySeconds(authorizationParam.getTokenRefresh());//refresh过期时间
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints){
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
    @Bean
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory){
        // return new InMemoryTokenStore(); //使用内存存储令牌 tokeStore
        return new RedisTokenStore(redisConnectionFactory); //使用redis存储令牌
    }
}
