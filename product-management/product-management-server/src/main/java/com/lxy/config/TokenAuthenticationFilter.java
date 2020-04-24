package com.lxy.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxy.pojo.CustomerDto;
import com.lxy.util.EncryptUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {


    /**
     * 经过过滤器，资源服务中就可以方便到的获取用户的身份信息：
     * CustomerDto customer = (CustomerDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("json‐token");
        if (token != null){
            //1.解析token
            String json = EncryptUtil.decodeUTF8StringBase64(token);
            JSONObject userJson = JSON.parseObject(json);
            //取出用户身份信息
            String principal = userJson.getString("principal");
            //将json转成对象
            CustomerDto customer = JSON.parseObject(principal, CustomerDto.class);
            JSONArray authoritiesArray = userJson.getJSONArray("authorities");

            String [] authorities = authoritiesArray.toArray(new String[authoritiesArray.size()]);

            //2.新建并填充authentication
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(customer, null, AuthorityUtils.createAuthorityList(authorities));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            //3.将authentication保存进安全上下文
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
