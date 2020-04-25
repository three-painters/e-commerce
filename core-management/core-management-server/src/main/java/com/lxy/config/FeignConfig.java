package com.lxy.config;

import com.alibaba.fastjson.JSON;
import com.lxy.util.EncryptUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Donily
 * @date 2020-04-25
 * @description Feign配置
 *              使用FeignClient进行服务间调用，传递headers信息
 */
@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String jsonTokenStr = request.getHeader("json‐token");

        if (jsonTokenStr != null) {
            //添加token
            requestTemplate.header("json‐token", jsonTokenStr);
        } else {
            //没有token就从oauth2中拿信息
            /**
             * 1.获取令牌内容
             */
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof OAuth2Authentication)) {
                // 无token访问网关内资源的情况，目 前仅有uua服务直接暴露
                return;
            }
            OAuth2Authentication oauth2Authentication = (OAuth2Authentication)authentication;
            Authentication userAuthentication = oauth2Authentication.getUserAuthentication();
            String principal = userAuthentication.getName();
            /**
             2.组装明文token，转发给微服务，放入header，名称为json‐token
             */
            List<String> authorities = new ArrayList();
            userAuthentication.getAuthorities().stream().forEach(s -> authorities.add(((GrantedAuthority) s).getAuthority()));

            OAuth2Request oAuth2Request = oauth2Authentication.getOAuth2Request();
            Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
            Map<String,Object> jsonToken = new HashMap<>(requestParameters);

            if(userAuthentication != null) {
                jsonToken.put("principal", principal);
                jsonToken.put("authorities", authorities);
            }
            //添加token
            requestTemplate.header("json‐token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));

        }

    }
}