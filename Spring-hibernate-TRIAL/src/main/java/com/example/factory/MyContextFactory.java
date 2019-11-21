package com.example.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.CustomerService;

public class MyContextFactory 
{
	public static CustomerService getMyContextFactory()
	{
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service=context.getBean("customerService",CustomerService.class);
		return service;
	}
}
