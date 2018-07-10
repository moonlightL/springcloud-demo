package com.extlight.springcloud.provider.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.extlight.springcloud.common.model.User;
import com.extlight.springcloud.provider.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static Map<Integer,User> map;
	
	static {
		map = new HashMap<>();
		for (int i=1; i<6; i++) {
			map.put(i, new User(i,"test" +i , "pwd" + i,8083));
		}
	}

	@Override
	public User getById(Integer id) {
		return map.get(id);
	}

}
