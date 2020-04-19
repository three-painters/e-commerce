package com.lxy.service.impl;

import com.lxy.api.CustomerApi;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerApi customerApi;

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

        UserDetails userDetails = User.withUsername(customer.getLoginName())
                .password(customer.getPassword()).authorities("p1").build();

        return userDetails;
    }
}
