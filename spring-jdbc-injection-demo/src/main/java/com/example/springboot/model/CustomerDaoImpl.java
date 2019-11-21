package com.example.springboot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDaoInterface 
{
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public void createCustomer() 
	{
		

	}

}
