package com.extlight.springcloud.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthenticationFilter extends ZuulFilter{

	/**
	 * 是否开启过滤
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        
		boolean flag = request.getRequestURI().contains("/login");
		// 如果是登录请求不进行过滤
		if (flag) {
			System.out.println("========不执行 zuul 过滤方法=======");
		} else {
			System.out.println("========执行 zuul 过滤方法=======");
		}
		return !flag;
	}

	/**
	 * 过滤器执行内容
	 */
	@Override
	public Object run() throws ZuulException {
		
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        // 此处模拟获取数据库或缓存中的 token
        String dbToken = "123456";
        // 此处简单检验 token
        if (token == null || "".equals(token) || !dbToken.equals(token)) {
        	context.setSendZuulResponse(false);
        	context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        
		return null;
	}

	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
