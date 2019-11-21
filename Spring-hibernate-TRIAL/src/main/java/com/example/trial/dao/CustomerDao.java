package com.example.trial.dao;

import java.util.List;

import com.example.trial.entity.Customer;

public interface CustomerDao
{
	
		public Customer createCustomer(Customer theCustomer);
		public List<Customer> getAllCustomer();
		public Customer getCustomerByid(int id);
		public List<Customer> getCustomerByFirstName(String firstName);
		
		public Customer updateCuastomer(String firstName,String lastName,String email,int id);

}
