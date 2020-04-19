package com.lxy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author Donily
 * @date 2020-04-19
 * @description oauth2服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    /*
    客户端详情服务
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("c1")
                .secret(new BCryptPasswordEncoder().encode("ycy"))
                .resourceIds("res1") //资源列表
                .authorizedGrantTypes("authorization_code", "password",
                        "client_credentials", "implicit","refresh_token") //允许的授权类型
                .scopes("all") //允许的授权范围
                .autoApprove(false) //false跳转到授权页面
                .redirectUris("http://www.baidu.com") //回调地址
                ;
    }

    /*
    令牌访问端点和令牌服务
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }

    /*
    令牌端点的安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    /*
    令牌管理服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService); //客户端详情服务
        service.setSupportRefreshToken(true); //支持刷新令牌
        service.setTokenStore(tokenStore); //令牌存储策略
        service.setAccessTokenValiditySeconds(7200); //令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200); //刷新令牌默认有效期3天
        return service;
    }

    /*
    设置授权码模式的授权码如何存取，暂时采用内存模式
    */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }


}
