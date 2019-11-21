package com.example.trial.Spring_hibernate_TRIAL;

import com.example.factory.MyContextFactory;
import com.example.service.CustomerService;
import com.example.trial.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CustomerService service = MyContextFactory.getMyContextFactory();
    	

		Customer c=service.updateCuastomer("RRR","GGG","BBB", 14);
		if(c!=null)
		{
			System.out.println("upadted "+c);
		}
		else {
			System.out.println("no record found");	
		}
    	
    }
}
