package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

@WebServlet("/SaveCustomer.do")
public class SaveCustomer extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private String name, type, email;
	private List<String> errors;
	private CustomerDaoImpl dao;
    
    public SaveCustomer() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcesst(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcesst(request, response);
	}
	
	protected void doProcesst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		errors = new ArrayList<String>();
		
		name = request.getParameter("name");
		if(name.length()<=0)
		{
			errors.add("invalid name");
		}
		
		type=request.getParameter("type");
		if(type.length()<=0)
		{
			errors.add("invalid type");
		}
		
		email=request.getParameter("email");
		
		if(email.length()<=0)
		{
			errors.add("invalid email");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("addcustomer.jsp");
			view.forward(request, response);
		}
		else
		{
			Customer c = new Customer(name, type, email);
			request.setAttribute("SUCCESS", c);
			dao = new CustomerDaoImpl();
			dao.createCustomer(c);
			RequestDispatcher view=request.getRequestDispatcher("ListCustomerController.do");
			view.forward(request, response);
		}
		
	}

}
