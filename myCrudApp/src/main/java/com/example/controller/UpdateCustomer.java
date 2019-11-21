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

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;


@WebServlet("/update.do")
public class UpdateCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CustomerDao dao = new CustomerDaoImpl();
	private List<String> errors;

	@Override
	public void init() throws ServletException 
	{
		dao = new CustomerDaoImpl();
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
//		Customer c = dao.getCustomerById(Integer.parseInt(request.getParameter("customerId").toString()));
//		request.setAttribute("customer", c);
//		RequestDispatcher view = request.getRequestDispatcher("update-form.jsp");
//		view.forward(request, response);
		
		errors = new ArrayList<String>();
		Customer c = dao.getCustomerById(Integer.parseInt(request.getParameter("customerId").toString()));
		
		String name = request.getParameter("name");
		if(name.length()<=0)
		{
			errors.add("invalid name");
		}
		
		String email = request.getParameter("email");
		if(email.length()<=0)
		{
			errors.add("invalid email");
		}
		
		String type = request.getParameter("type");
		if(type.length()<=0)
		{
			errors.add("invalid type");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("update-form.jsp");
			view.forward(request, response);
			
		}
		else
		{
			c.setName(name); ;
			c.setEmail(email);
			c.setType(type);
			dao.updateCustomer(c);
			RequestDispatcher view=request.getRequestDispatcher("ListCustomerController.do");
			view.forward(request, response);
		}
	
	}

}