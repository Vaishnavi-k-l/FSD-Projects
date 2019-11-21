package com.example.springboot.spring_hibernate_integration.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.example.springboot.spring_hibernate_integration.service.CustomerService;
import com.example.springboot.spring_hibernate_integration.service.CustomerServiceImpl;

public class MyContextFactory 
{
	public static CustomerService getContextFactory()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//CustomerService service=context.getBean("customerService", CustomerService.class);
		CustomerService service = context.getBean("customerServiceImpl",CustomerServiceImpl.class);
		return service;
	}
	
}
