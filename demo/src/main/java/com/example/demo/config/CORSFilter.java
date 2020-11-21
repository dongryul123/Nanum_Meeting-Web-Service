package com.example.demo.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

// @CrossOrigin 어노테이션을 UserControlller.java 에서 써주면 Config 따로 작성안해도 됨!

@Configuration
public class CORSFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
		throws IOException, ServletException {
		
		System.out.println("필터링 진행 중입니다..");

		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type,"
				+ "Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		chain.doFilter(req, res);
	}
	
	public void init(FilterConfig filterConfig) {}
	
	public void destory() {}
}
