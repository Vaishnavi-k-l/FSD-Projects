package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DaoImplementation;
import com.example.dao.DaoInterface;
import com.example.entity.ToDo;
import com.example.service.ToDoService;

@WebServlet("/add-todo.do")
public class AddToDoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private DaoInterface dao= null;
	
	private ToDoService todoService = new ToDoService();
  
    public AddToDoServlet()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("WEB-INF/views/add-todo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dao = new DaoImplementation();
		String newTodo = request.getParameter("todo");
		dao.insertTodo(newTodo);
		
		//todoService.addTodo(new ToDo(newTodo));
		response.sendRedirect("list-todos.do");
	}
	
}
