package com.extlight.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.extlight.springcloud.common.model.User;

@FeignClient(value="USER-API")
public interface UserFeignService {
    
    @RequestMapping("/provider/user/get/{id}")
    public User get(@PathVariable("id") Integer id);
}