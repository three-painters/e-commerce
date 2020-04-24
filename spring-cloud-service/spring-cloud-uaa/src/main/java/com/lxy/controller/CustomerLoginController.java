package com.lxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxy.model.CustomerLogin;
import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.service.CustomerLoginService;
import com.lxy.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/customerLogin")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;

}

