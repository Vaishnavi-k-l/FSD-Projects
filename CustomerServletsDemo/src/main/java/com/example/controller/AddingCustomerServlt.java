package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;

public class AddingCustomerServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private int id;
	private List<String> errors;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		errors = new ArrayList<String>();
	
		
		String id_obtained = request.getParameter("id");
		try 
		{
			id=Integer.parseInt(id_obtained);
		} 
		catch (Exception e)
		{
			
			errors.add("id field must be numeric");
		}
		
		name=request.getParameter("name");
		if(name.length()<=0)
		{
			errors.add("invalid title");
		}
		
		type=request.getParameter("type");
		if(type.equals("Unknown"))
		{
			errors.add("select a type");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("AddCustomerServlet.view");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("SUCCESS", new Customer(name, id, type));
			RequestDispatcher view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}

	}

}