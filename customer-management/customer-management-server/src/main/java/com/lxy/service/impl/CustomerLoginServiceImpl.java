package com.lxy.service.impl;

import com.lxy.model.CustomerLogin;
import com.lxy.mapper.CustomerLoginMapper;
import com.lxy.service.CustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
