package com.myCompany.spring_rest_application.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myCompany.spring_rest_application.entity.Todo;
import com.myCompany.spring_rest_application.service.ToDoService;


@RestController
@RequestMapping("/api")
public class ToDoRestController  
{
	@Autowired
	private ToDoService toDoService;
	@GetMapping(value ="/todos")
	public List<Todo> listTodo()
	{
		return toDoService.getAllToDo();
	}
}
