package com.lxy.api;

import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import com.lxy.pojo.PermissionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-management")
public interface PermissionApi {

	@PostMapping("/customer/permission/getPermissionsByCustomerId")
	BaseResult<List<PermissionDto>> getPermissionsByCustomerId(@RequestParam(value = "customerId") Integer customerId);
}
