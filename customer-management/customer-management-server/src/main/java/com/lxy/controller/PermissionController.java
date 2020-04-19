package com.lxy.controller;


import com.lxy.pojo.BaseResult;
import com.lxy.pojo.PermissionDto;
import com.lxy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Donily
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/getPermissionsByCustomerId")
    public BaseResult<List<PermissionDto>> getPermissionsByCustomerId(Integer customerId) {
        if (customerId == null) {
            return BaseResult.paramError();
        }

        List<PermissionDto> resList = permissionService.getPermissionsByCustomerId(customerId);
        return BaseResult.success(resList);
    }
}

