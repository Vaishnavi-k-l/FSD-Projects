package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.DaoImplementation;
import com.example.dao.DaoInterface;
import com.example.entity.ToDo;
import com.example.service.LoginService;
import com.example.service.ToDoService;


@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private LoginService userValidationService = new LoginService();
	private ToDoService todoService = new ToDoService();
	
	private DaoInterface dao= null;
	private List<ToDo> listofLogidetails = null;
   
    public LoginServlet()
    {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		dao = new DaoImplementation();
		listofLogidetails = dao.getUser();
		
		for(ToDo user : listofLogidetails)
		{
			if((user.getName().equals(name)) && (user.getPassword().equals(password)))
			{
				
				request.getSession().setAttribute("name", name);
				//request.getRequestDispatcher("WEB-INF/views/dummy.jsp").forward(request, response);
				response.sendRedirect("list-todos.do");
			}
			else 
			{
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			}
		}
		

//		boolean isUserValid = userValidationService.isUserValid(name, password);
//
//		if (isUserValid)
//		{
//			request.getSession().setAttribute("name", name);
//			response.sendRedirect("list-todos.do");
//		} 
//		else 
//		{
//			request.setAttribute("errorMessage", "Invalid Credentials!");
//			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//		}
	}
	
}
