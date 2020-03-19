package com.lxy.service.impl;

import com.lxy.model.CustomerLoginLog;
import com.lxy.mapper.CustomerLoginLogMapper;
import com.lxy.service.CustomerLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登陆日志表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class CustomerLoginLogServiceImpl extends ServiceImpl<CustomerLoginLogMapper, CustomerLoginLog> implements CustomerLoginLogService {

}
