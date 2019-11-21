package com.example.springboot.spring_hibernate_integration.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.springboot.spring_hibernate_integration.dao.CustomerDao;
import com.example.springboot.spring_hibernate_integration.entity.Customer;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
//@Component("customerService")
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public Customer createCustomer(Customer theCustomer) 
	{
		return customerDao.createcustomer(theCustomer);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() 
	{
		return customerDao.getAllCustomer();
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id)
	{
		Customer cust = customerDao.getCustomerById(id);
		if(cust != null)
		{
			return cust;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	@Transactional
	public List<Customer> getCustomerByFirstName(String fname) 
	{
		return customerDao.getCustomerByFirstName(fname);
	}

	@Override
	@Transactional
	public Customer updateCustomer(String fname, String lname, String email, int id) 
	{
		Customer c = customerDao.updateCustomer(fname, lname, email, id);
		if(c != null)
		{
			return c;
		}
		else
		{
			return null;
		}
	}

}
