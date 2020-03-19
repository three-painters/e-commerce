package com.lxy.service.impl;

import com.lxy.model.CustomerPointLog;
import com.lxy.mapper.CustomerPointLogMapper;
import com.lxy.service.CustomerPointLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户积分日志表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class CustomerPointLogServiceImpl extends ServiceImpl<CustomerPointLogMapper, CustomerPointLog> implements CustomerPointLogService {

}
