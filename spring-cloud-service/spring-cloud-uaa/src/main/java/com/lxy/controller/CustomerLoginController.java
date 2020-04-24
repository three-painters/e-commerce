package com.lxy.controller;

import com.lxy.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

