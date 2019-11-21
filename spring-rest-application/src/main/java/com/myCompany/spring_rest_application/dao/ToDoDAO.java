package com.myCompany.spring_rest_application.dao;

import java.util.List;

import com.myCompany.spring_rest_application.entity.Todo;

public interface ToDoDAO 
{
	public List<Todo> getAllToDo();
}
