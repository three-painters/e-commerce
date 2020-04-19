package com.lxy.api;

import com.lxy.pojo.BaseResult;
import com.lxy.pojo.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "customer-management")
public interface CustomerApi {

	@PostMapping("/customer/customerLogin/getCustomerByLoginName")
	BaseResult<CustomerDto> getCustomerByLoginName(@RequestParam(value = "loginName") String loginName);

}
