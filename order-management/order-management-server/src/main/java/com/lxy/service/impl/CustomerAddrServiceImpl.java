package com.lxy.service.impl;

import com.lxy.model.CustomerAddr;
import com.lxy.mapper.CustomerAddrMapper;
import com.lxy.service.CustomerAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class CustomerAddrServiceImpl extends ServiceImpl<CustomerAddrMapper, CustomerAddr> implements CustomerAddrService {

}
