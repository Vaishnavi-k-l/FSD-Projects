package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;


public class ListCustServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	private List<Customer> list=null;
	
    public ListCustServlet() 
    {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProcessRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ProcessRequest(request, response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Customer>();
		list.add(new Customer("Vaish",1,"Normal"));
		list.add(new Customer("Advika", 2, "Corporate"));
		list.add(new Customer("Ash", 3, "Normal"));
		out.println("<html><title>List of all Available Customers </title><body><table border='1'><tr><td>Name</td><td>Id</td><td>Type</td></tr>");
		
		for(Customer c:list)
		{
			out.println("<tr><td>"+c.getName()+"</td><td>"+c.getId()+"</td><td>"+c.getType()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
	}
}
