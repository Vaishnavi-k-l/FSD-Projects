package com.example.controller;

import java.io.IOException;
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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CustomerDao dao = null;
   
    public SearchServlet() 
    {
        super();
       
    }

    @Override
	public void init() throws ServletException {
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
		List<Customer> list=dao.findCustomer(request.getParameter("search-what"));
		if(list.isEmpty())
		{
			RequestDispatcher view=request.getRequestDispatcher("ListCustomerController.do");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("customers", list);
			RequestDispatcher view=request.getRequestDispatcher("search-list.jsp");
			view.forward(request, response);
		}

	}

}
