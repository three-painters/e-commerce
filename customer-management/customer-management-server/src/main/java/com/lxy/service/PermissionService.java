package com.lxy.service;

import com.lxy.model.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.pojo.PermissionDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Donily
 * @since 2020-04-19
 */
public interface PermissionService extends IService<Permission> {

    List<PermissionDto> getPermissionsByCustomerId(Integer customerId);
}
