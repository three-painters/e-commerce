package com.lxy.service.impl;

import com.alibaba.fastjson.JSON;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.pojo.PermissionDto;
import com.lxy.service.CustomerLoginService;
import com.lxy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerLoginService customerLoginService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据登录名获取用户
        CustomerDto customer = customerLoginService.getCustomerByLoginName(s);
        //用户找不到 返回null,由provider抛出异常
        if (customer == null) {
            return null;
        }

        //用户权限
        List<PermissionDto> permissions = permissionService.getPermissionsByCustomerId(customer.getCustomerId());

        String[] permissionArr = null;
        if (!CollectionUtils.isEmpty(permissions)) {
            List<String> permissionCodes = permissions.stream().map(PermissionDto::getCode).collect(Collectors.toList());
            permissionArr = new String[permissionCodes.size()];
            permissionCodes.toArray(permissionArr);
        }

        //这里将user转为json，将整体user存入userDetails
        String principal = JSON.toJSONString(customer);

        UserDetails userDetails = User.withUsername(principal)
                .password(customer.getPassword()).authorities(permissionArr).build();

        return userDetails;
    }
}
