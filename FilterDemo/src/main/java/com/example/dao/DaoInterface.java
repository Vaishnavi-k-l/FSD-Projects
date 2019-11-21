package com.example.dao;

import java.util.List;

import com.example.entity.ToDo;
import com.example.entity.ToDoList;

public interface DaoInterface
{
	public List<ToDo> getUser();
	public List<ToDoList> getTodolist();
	public void insertTodo(String name);
	public ToDoList getListbyId(int id);
	public void Delete(ToDoList list);
}
