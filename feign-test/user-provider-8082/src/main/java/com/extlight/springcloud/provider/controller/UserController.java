package com.extlight.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.extlight.springcloud.common.model.User;
import com.extlight.springcloud.provider.service.UserService;

@RestController
@RequestMapping("/provider/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/get/{id}")
	public User get(@PathVariable("id") Integer id) {
		return this.userService.getById(id);
	}
}
