package com.example.springboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.springboot.model.Customer;

public class CustomerMapper implements RowMapper<Customer>
{
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Customer customer = new Customer();
		customer.setFirstname(rs.getString("firstname"));
		customer.setLastname(rs.getString("lastname"));
		customer.setEmail(rs.getString("email"));
		return customer;
	}

}
