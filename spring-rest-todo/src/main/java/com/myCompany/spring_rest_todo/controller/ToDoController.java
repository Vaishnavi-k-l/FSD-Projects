package com.myCompany.spring_rest_todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myCompany.spring_rest_todo.model.Todo;
import com.myCompany.spring_rest_todo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class ToDoController 
{
	private TodoService todoservice;
	private List<Todo> todoList ;
	
	@RequestMapping("/list")
	public List<Todo> listtodo()
	{
		return null;
	}
	
	@RequestMapping("/todoform")
	public String showTodoform()
	{
		return "showtodoform";
	}
	
	@RequestMapping("/process")
	public String addTodo()
	{
		return  null;//todoservice.addTodo();
	}
	
}
