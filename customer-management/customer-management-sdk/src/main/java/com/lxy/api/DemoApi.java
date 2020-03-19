package com.lxy.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-management")
public interface DemoApi {

	@PostMapping("/customer/user/getUserPojoByEnterpriseId")
	List getList(@RequestParam(value = "id") Integer enterpriseId);

}
