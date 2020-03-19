package com.lxy.service.impl;

import com.lxy.model.CustomerBalanceLog;
import com.lxy.mapper.CustomerBalanceLogMapper;
import com.lxy.service.CustomerBalanceLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户余额变动表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class CustomerBalanceLogServiceImpl extends ServiceImpl<CustomerBalanceLogMapper, CustomerBalanceLog> implements CustomerBalanceLogService {

}
