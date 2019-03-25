package com.extlight.springcloud.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extlight.springcloud.common.vo.Result;

@RestController
@RequestMapping("/user")
public class LoginController {

	@PostMapping("/login")
	public Result login(String username, String password, HttpServletResponse response) {
		
		
		if ("admin".equals(username) && "admin".equals(password)) {
			// 模拟生成 token，实际开发中 token 应存放在数据库或缓存中
			String token = "123456";
			Cookie cookie = new Cookie("token", token);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 10);
			response.addCookie(cookie);
			
			return Result.success();
		}
		
		return Result.fail(401, "账号或密码错误");
	}
}
