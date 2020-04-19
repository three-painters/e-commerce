package com.lxy.service.impl;

import com.lxy.model.Permission;
import com.lxy.mapper.PermissionMapper;
import com.lxy.pojo.PermissionDto;
import com.lxy.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Donily
 * @since 2020-04-19
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> getPermissionsByCustomerId(Integer customerId) {
        List<PermissionDto> dtos = new ArrayList<>();

        List<Permission> permissions = permissionMapper.getPermissionsByCustomerId(customerId);

        if (!CollectionUtils.isEmpty(permissions)) {
            for (Permission permission : permissions) {
                PermissionDto dto = new PermissionDto();
                BeanUtils.copyProperties(permission, dto);
                dtos.add(dto);
            }
        }

        return dtos;
    }
}
