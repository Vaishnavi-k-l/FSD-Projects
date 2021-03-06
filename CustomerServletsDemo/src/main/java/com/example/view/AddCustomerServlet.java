package com.example.view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddCustomerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<String> l=null;
   
    public AddCustomerServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doProcess(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		l=(List<String>) request.getAttribute("ERROR");
		if(l!=null)
		{
			out.println("please correct the bellow error(s)<br/>");
			for(String str:l)
			{
				out.println("<font color='red'>"+str+"</font><br/>");
			}
		}
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<!-- Default form login -->\r\n" + 
				"<form class=\"text-center border border-light p-5\" action=\"addCustomer.do\" method=\"post\">\r\n" + 
				"\r\n" + 
				"    <p class=\"h4 mb-4\">Input Customer Details.</p>\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"name\" name=\"name\">\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"id\" name=\"id\">\r\n" + 
				"\r\n" + 
				" <select class=\"browser-default custom-select\" name=\"type\">\r\n" + 
				"  <option value=\"Unknown\">Select the Employee type</option>\r\n" + 
				"  <option value=\"Corporate\">Corporate</option>\r\n" + 
				"  <option value=\"Normal\">Normal</option>\r\n" + 
				"  \r\n" + 
				"</select>\r\n" + 
				"\r\n" + 
				"    <!-- Sign in button -->\r\n" + 
				"    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New Customer</button>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</form>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
	

}
