package com.example.springboot.dao;

import java.util.List;

import com.example.springboot.model.Customer;

public interface DaoInterface
{
	public void createCustomer(Customer customer);
	//public List<Customer> listCustomer();

	public void updateCustomer(String firstname, String lastname, String email);
	public List<Customer> getAllCustomer();
	public void deleteCustomer();
}
