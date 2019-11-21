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


@WebServlet("/sorting.do")

public class SortServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private List<Customer> list = null;
	private CustomerDao dao;
	private String sortType = null;
	
	
       
   
    @Override
	public void init() throws ServletException 
    {
    	dao = new CustomerDaoImpl();	
	}
       
  
    public SortServlet() 
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
		sortType = request.getParameter("sort_type");
		if(sortType.equalsIgnoreCase("ascending"))
		{
			list =  dao.getAscending();
			request.setAttribute("customers", list);
			RequestDispatcher view=request.getRequestDispatcher("listcustomer.jsp");
			view.forward(request, response);
		}
		else if(sortType.equalsIgnoreCase("descending"))
		{
			list = dao.getDescending();
			request.setAttribute("customers", list);
			RequestDispatcher view=request.getRequestDispatcher("listcustomer.jsp");
			view.forward(request, response);
		}
	}
}
