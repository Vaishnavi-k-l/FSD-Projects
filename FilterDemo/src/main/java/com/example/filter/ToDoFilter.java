package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"*.do"})
public class ToDoFilter implements Filter 
{


	public void destroy()
	{
		
	}

	
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest httpRequest=(HttpServletRequest)servletrequest;
		
		if(httpRequest.getSession().getAttribute("name")!=null)
		{
			chain.doFilter(servletrequest, servletresponse);
		}
		else
		{	
			httpRequest.getRequestDispatcher("LoginServlet.do").forward(servletrequest, servletresponse);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}

}
