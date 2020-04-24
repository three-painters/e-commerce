package com.lxy.service.impl;

import com.alibaba.fastjson.JSON;
import com.lxy.api.CustomerApi;
import com.lxy.api.PermissionApi;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.pojo.PermissionDto;
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
    private CustomerApi customerApi;
    @Autowired
    private PermissionApi permissionApi;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据登录名获取用户
        CustomerDto customer = null;
        BaseResult<CustomerDto> customerRes = customerApi.getCustomerByLoginName(s);
        if (!customerRes.getIsError() && customerRes.getData() != null) {
            customer = customerRes.getData();
        }
        //用户找不到 返回null,由provider抛出异常
        if (customer == null) {
            return null;
        }

        //用户权限
        List<PermissionDto> permissions = null;
        BaseResult<List<PermissionDto>> permissionsRes = permissionApi.getPermissionsByCustomerId(customer.getCustomerId());
        if (!permissionsRes.getIsError() && permissionsRes.getData() != null) {
            permissions = permissionsRes.getData();
        }

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
