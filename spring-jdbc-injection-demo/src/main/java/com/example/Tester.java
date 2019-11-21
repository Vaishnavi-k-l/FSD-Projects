package com.example;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springboot.dao.DaoImplementation;
import com.example.springboot.dao.DaoInterface;
import com.example.springboot.model.Customer;

public class Tester 
{
	public static void main(String[] args)
	{
		/*List<Customer> list = null;
		Scanner in = new Scanner(System.in);
		try 
		{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			DaoInterface daointerface = context.getBean("customerdao", DaoImplementation.class);
	
			//daointerface.createCustomer(new Customer("Advika", "AP", "addsc@xyz.com"));
			//System.out.println("Record inserted");
			
			
			//-------------Listing customer details--------------------
			/*list = daointerface.listCustomer();
			for (Customer c : list) 
			{
				System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getEmail());
			}*/
			
			//----------------------Updating customer-----------------------------*/
			/*System.out.println("Enter the updated firstname");
			String fname = in.next();
			System.out.println("Enter the updated lastname");
			String lname = in.next();
			System.out.println("Enter the updated email");
			String email = in.next();
			daointerface.updateCustomer(fname, lname, email);
			*/
			
			//-------------------------Listing customer details using jdbcTemplate------------------------------
			/*List<Customer> list1 = daointerface.getAllCustomer();
			
			Iterator<Customer> i = list1.iterator();
			while(i.hasNext())
			{ 
				Customer c=i.next();
				System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getEmail());
			}
			*/
			
			//Deleting customer
		/*
		 * daointerface.deleteCustomer();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		
		
		//-----------------------------------------------Using pure java annotations----------------------------------------------
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanDefinitionClass.class);
		DaoInterface dao = context.getBean("daoImplementation", DaoImplementation.class );
		dao.createCustomer(new Customer("Alia", "P", "alia@gmail"));
		System.out.println("Record inserted");
		
		System.out.println("Listing all customers");
		List<Customer> custList = dao.getAllCustomer();
		Iterator<Customer> i = custList.iterator();
		while(i.hasNext())
		{ 
			Customer c=i.next();
			System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getEmail());
		}
		
		
	}
}
