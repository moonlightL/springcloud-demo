package com.extlight.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

	@Value("${env}")
    private String env; // 从配置中心获取
	
	@RequestMapping("/getConfigInfo")
	public String getConfigInfo() {
		return env;
	}
}
