package com.lxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "ycy0731";

    @Bean
    public TokenStore tokenStore() {
        //Jwt令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);  //对成密钥，资源服务器使用此密钥来验证
        return converter;
    }

//    @Bean
//    public TokenStore tokenStore() {
//        //使用内存
//        return new InMemoryTokenStore();
//    }
}
