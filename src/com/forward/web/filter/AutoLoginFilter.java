package com.forward.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.forward.model.User;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;


public class AutoLoginFilter implements Filter {
	private UserService us = new UserServiceImpl();
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		User user = new User();
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("userName")){
					user.setU_name(cookie.getValue());
				}
				if(cookie.getName().equals("password")){
					user.setU_pwd(cookie.getValue());
				}
			}
			user = us.login(user);
			req.getSession().setAttribute("user", user);
			
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
