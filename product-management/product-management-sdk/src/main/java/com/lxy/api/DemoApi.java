package com.lxy.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "product-management")
public interface DemoApi {

	@PostMapping("/product/user/getUserPojoByEnterpriseId")
	List getList(@RequestParam(value = "id") Integer enterpriseId);

}
