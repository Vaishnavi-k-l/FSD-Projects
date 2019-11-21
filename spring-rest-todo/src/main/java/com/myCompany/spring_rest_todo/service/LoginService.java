package com.myCompany.spring_rest_todo.service;

import com.myCompany.spring_rest_todo.model.User;

public interface LoginService 
{
	public boolean ValidateUser(User theUser);
}
