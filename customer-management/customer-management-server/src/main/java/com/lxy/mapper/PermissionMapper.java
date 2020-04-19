package com.lxy.mapper;

import com.lxy.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Donily
 * @since 2020-04-19
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getPermissionsByCustomerId(@Param("customerId") Integer customerId);
}
