package com.myCompany.spring_rest_todo.service;

import org.springframework.stereotype.Service;

import com.myCompany.spring_rest_todo.model.User;

@Service
public class LoginServiceImpl implements LoginService 
{

	@Override
	public boolean ValidateUser(User theUser) 
	{
		if (theUser.getUsername().equalsIgnoreCase("dummy") && theUser.getPassword().equalsIgnoreCase("dummy"))
		{
			return true;
		}
		return false;
	}

}
