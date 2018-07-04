package com.extlight.springcloud.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.extlight.springcloud.common.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@RequestMapping("get/{id}")
//	public User get(@PathVariable("id") Integer id) throws Exception {
//		// 没有使用 Eureka 时，uri 为消息提供者的地址，需要指定 ip 和 端口
//		return restTemplate.getForObject(new URI("http://localhost:8081/provider/user/get/" + id), User.class);
//	}
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("get/{id}")
	public User get(@PathVariable("id") Integer id) throws Exception {
		
		List<ServiceInstance> list = this.client.getInstances("USER-API");
		String uri = "";
	    for (ServiceInstance instance : list) {
	        if (instance.getUri() != null && !"".equals(instance.getUri().toString())) {
	        	uri = instance.getUri().toString();
	        	break;
	        }
	    }
		return restTemplate.getForObject(uri + "/provider/user/get/" + id, User.class);
	}
	
}
