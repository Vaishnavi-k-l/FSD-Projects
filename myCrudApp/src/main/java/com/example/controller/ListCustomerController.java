package com.example.controller;

import java.io.IOException;

import java.util.List;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;


@WebServlet("/ListCustomerController.do")
//If we are using multiple url patterns use urlPattersn =".hdsh" in the above

public class ListCustomerController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<Customer> list = null;
	private CustomerDao dao;
	
       
   
    @Override
	public void init() throws ServletException 
    {
    	dao = new CustomerDaoImpl();	
	}


	public ListCustomerController() 
    {
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
		list=dao.getAllCustomer();
		request.setAttribute("customers", list);
		RequestDispatcher view=request.getRequestDispatcher("listcustomer.jsp");
		view.forward(request, response);
		
	}

}
