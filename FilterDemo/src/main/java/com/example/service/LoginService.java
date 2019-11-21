package com.example.service;

public class LoginService 
{
	public boolean isUserValid(String name, String password) 
	{
		if (name.equals("dummy") && password.equals("dummy"))
			return true;

		return false;
	}
}
