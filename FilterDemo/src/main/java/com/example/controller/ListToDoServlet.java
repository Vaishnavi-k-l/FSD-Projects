package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DaoImplementation;
import com.example.dao.DaoInterface;
import com.example.entity.ToDoList;
import com.example.service.ToDoService;


@WebServlet("/list-todos.do")
public class ListToDoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private DaoInterface dao= null;
	
	private ToDoService todoService = new ToDoService();
	
    public ListToDoServlet() 
    {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dao = new DaoImplementation();
		List<ToDoList> todolist = dao.getTodolist();
		request.setAttribute("ListOfTodo", todolist);
		//request.setAttribute("todos", todoService.retrieveTodos());
		request.getRequestDispatcher("WEB-INF/views/list-todos.jsp").forward(request, response);
	}

	
}
