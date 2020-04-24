package com.lxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxy.model.CustomerLogin;
import com.lxy.mapper.CustomerLoginMapper;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.service.CustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements CustomerLoginService {

    @Autowired
    private CustomerLoginMapper customerLoginMapper;

    @Override
    public CustomerDto getCustomerByLoginName(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return null;
        }

        QueryWrapper<CustomerLogin> wrapper = new QueryWrapper();
        wrapper.eq("login_name", loginName);
        List<CustomerLogin> resList = customerLoginMapper.selectList(wrapper);

        if (CollectionUtils.isEmpty(resList)) {
            return null;
        } else {
            CustomerDto customer = new CustomerDto();
            BeanUtils.copyProperties(resList.get(0), customer);
            return customer;
        }
    }
}
