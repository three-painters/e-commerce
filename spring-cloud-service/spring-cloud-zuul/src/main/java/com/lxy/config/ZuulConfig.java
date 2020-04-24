package com.lxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public AuthFilter preFileter() {
        return new AuthFilter();
    }
}
