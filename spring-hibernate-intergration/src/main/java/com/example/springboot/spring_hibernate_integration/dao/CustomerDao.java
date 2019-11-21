package com.example.springboot.spring_hibernate_integration.dao;
import java.util.List;

import com.example.springboot.spring_hibernate_integration.entity.Customer;

public interface CustomerDao 
{
	public Customer createcustomer(Customer theCustomer);
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public List<Customer> getCustomerByFirstName(String fname);
	public Customer updateCustomer(String fname, String lname, String email, int id);
}
