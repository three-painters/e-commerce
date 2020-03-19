package com.lxy.service.impl;

import com.lxy.model.ProductInfo;
import com.lxy.mapper.ProductInfoMapper;
import com.lxy.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

}
