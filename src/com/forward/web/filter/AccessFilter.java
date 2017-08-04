package com.forward.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AccessFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpServletResponse res = (HttpServletResponse) response; 
		
		
		if(!req.getServletPath().equals("/login")){			
			if(!req.getServletPath().equals("/index.jsp")){
				if(req.getSession().getAttribute("user") == null){
					res.sendRedirect(req.getContextPath()+"/index.jsp");
					return;
				}
			}
		}
		if(req.getServletPath().equals("/index.jsp")&&req.getSession().getAttribute("user") != null){
			res.sendRedirect(req.getContextPath()+"/admin.jsp");return;
		}
		chain.doFilter(request, response);
	}


}
