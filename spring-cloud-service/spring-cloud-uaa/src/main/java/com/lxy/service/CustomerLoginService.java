package com.lxy.service;

import com.lxy.model.CustomerLogin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.pojo.CustomerDto;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
public interface CustomerLoginService extends IService<CustomerLogin> {

    CustomerDto getCustomerByLoginName(String loginName);
}
