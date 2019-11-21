package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao 
{
	public List<Customer> getAllCustomer();
	public void createCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void updateCustomer(Customer c);
	
	public List<Customer> findCustomer(String str);
	
	public List<Customer> getAscending();
	public List<Customer> getDescending();
}
