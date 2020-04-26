package com.lxy.controller;


import com.lxy.api.CustomerApi;
import com.lxy.model.ProductInfo;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.pojo.ProductInfoDto;
import com.lxy.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品信息表 前端控制器
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private CustomerApi customerApi;

    @RequestMapping("/getProductInfoById")
    @PreAuthorize("hasAnyAuthority('p1')")
    public BaseResult<ProductInfoDto> getProductInfoById(Integer id) {
        if (id == null) {
            return BaseResult.paramError();
        }

        ProductInfo productInfo = productInfoService.getById(id);

        ProductInfoDto dto = null;

        if (productInfo != null) {
            dto = new ProductInfoDto();
            BeanUtils.copyProperties(productInfo, dto);
        }

        return BaseResult.success(dto);
    }

    @RequestMapping("/testFeign")
    public BaseResult<CustomerDto> testFeign() {
        BaseResult<CustomerDto> customerRes = customerApi.getCustomerByLoginName("zhangsan");
        return customerRes;
    }

}

