package org.Customer.app.factory;

import org.Customer.app.module.Customer;

import java.util.List;

public interface CustomerFactory
{

	public Customer createCustomer(int id, String name, String email);
	public List<Customer> getAllCustomer();
	
	public void findById(int id);
	public void deleteCustomer(int id);
	public void updateCustomer(int id);
}
