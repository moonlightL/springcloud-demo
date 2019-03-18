package com.extlight.springcloud.config.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;

@Component
public class WebHookFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = new String(httpServletRequest.getRequestURI());

		// 只过滤 /actuator/bus-refresh请求
		if (!url.endsWith("/actuator/bus-refresh")) {
			chain.doFilter(request, response);
			return;
		}

		// 使用 HttpServletRequest 包装原始请求达到修改 post 请求中 body 内容的目的
		CustometRequestWrapper requestWrapper = new CustometRequestWrapper(httpServletRequest);

		chain.doFilter(requestWrapper, response);

	}

	@Override
	public void destroy() {

	}

	private class CustometRequestWrapper extends HttpServletRequestWrapper {
		public CustometRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			byte[] bytes = new byte[0];
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

			return new ServletInputStream() {
				@Override
				public boolean isFinished() {
					return byteArrayInputStream.read() == -1 ? true : false;
				}

				@Override
				public boolean isReady() {
					return false;
				}

				@Override
				public void setReadListener(ReadListener readListener) {

				}

				@Override
				public int read() throws IOException {
					return byteArrayInputStream.read();
				}
			};
		}
	}
}
