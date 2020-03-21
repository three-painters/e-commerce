package com.lxy.controller;


import com.lxy.model.CustomerLogin;
import com.lxy.pojo.BaseResult;
import com.lxy.service.CustomerLoginService;
import com.lxy.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @RequestMapping("/saveCustomerLoginMsg")
    public BaseResult saveCustomerLoginMsg(@RequestBody CustomerLogin login) {
        if (login == null || StringUtils.isBlank(login.getLoginName()) ||
             StringUtils.isBlank(login.getPassword())) {
            return BaseResult.paramError();
        }

        login.setUserStatus(CustomerLogin.USER_STATUS_NORMAL);
        login.setModifiedTime(DateUtils.asLocalDateTime(new Date()));

        boolean save = customerLoginService.save(login);

        if (save) {
            return BaseResult.success();
        } else {
            return BaseResult.error("500", "用户注册失败");
        }
    }
}

