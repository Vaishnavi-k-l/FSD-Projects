package com.example.springboot.spring_hibernate_intergration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springboot.spring_hibernate_integration.entity.Customer;
import com.example.springboot.spring_hibernate_integration.service.CustomerService;
import com.example.springboot.spring_hibernate_integration.service.CustomerServiceImpl;



public class Tester
{
	public static void main(String[] args)
	
	{
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerService service=context.getBean("customerServiceImpl",CustomerServiceImpl.class);
		//CustomerService service = MyContextFactory.getContextFactory();
		
//		Customer theCustomer=service.createCustomer(new Customer("Shane", "Warne", "shane@luv2code.com"));
//		System.out.println(theCustomer);
//		
//		List<Customer> custlist = service.getAllCustomer();
//		Iterator<Customer> i = custlist.iterator();
//		while(i.hasNext())
//		{
//			Customer c = i.next();
//			System.out.println(c);
//		}
//		
//		
		
		Customer c=service.updateCustomer("RRR","GGG","BBB", 14);
		if(c!=null)
		{
			System.out.println("upadted "+c);
		}
		else {
			System.out.println("no record found");	
		}
			
		
		/*
		 * CustomerService serviceobj = context.getBean("customerService",
		 * CustomerService.class); Customer cust = serviceobj.createCustomer(new
		 * Customer("Henry", "Cavil", "henry@gmail"));
		 */
	}
	
}

