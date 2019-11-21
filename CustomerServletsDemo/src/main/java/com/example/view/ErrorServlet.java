package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;

public class ErrorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public ErrorServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		@SuppressWarnings("unchecked")
		Object obj = request.getAttribute("ERROR");
		List<String> errorlist = (List<String>)request.getAttribute("ERROR");
		out.println("Please correct the below errors:<br/>");
		
		for(String str : errorlist)
		{
			out.println("<font color='red'>" + str + "</font><br/>");
		}
		out.println("<a href='addCustomer.html'>Try again</a>");
		
	}
		

}
