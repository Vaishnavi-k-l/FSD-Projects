package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DaoImplementation;
import com.example.dao.DaoInterface;
import com.example.entity.ToDo;
import com.example.entity.ToDoList;
import com.example.service.ToDoService;


@WebServlet("/delete-todo.do")
public class DeleteToDoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private ToDoService todoService = new ToDoService();
	private DaoInterface dao= null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		dao = new DaoImplementation();
		int listid = Integer.parseInt(request.getParameter("listId").toString());
		ToDoList obj = dao.getListbyId(listid);
		dao.Delete(obj);
	
		//todoService.deleteTodo(new ToDo(request.getParameter("todo")));
		response.sendRedirect("list-todos.do");
	}


}
