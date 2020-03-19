package com.lxy.service.impl;

import com.lxy.model.ProductCategory;
import com.lxy.mapper.ProductCategoryMapper;
import com.lxy.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

}
