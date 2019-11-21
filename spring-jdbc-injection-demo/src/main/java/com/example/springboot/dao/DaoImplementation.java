package com.example.springboot.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springboot.model.Customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@NoArgsConstructor
//@AllArgsConstructor


//This @Component is for annotated spring part

//@Component("customerdao")


public class DaoImplementation implements DaoInterface
{	
	
//	private DataSource datasource = null;
/*
	public DaoImplementation(DataSource dataSource) 
	{

		this.datasource = dataSource;
	}
	*/
//
//	@Override
//	public void createCustomer(Customer customer) {
//		Connection connection = null;
//		Statement statement = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			connection = datasource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(datasource.toString());
//
//		try {
//			pstmt = connection.prepareStatement("insert into Customerspring(firstname,lastname,email) values(?,?,?)");
//			pstmt.setString(1, customer.getFirstname());
//			pstmt.setString(2, customer.getLastname());
//			pstmt.setString(3, customer.getEmail());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Listing customers
//	@Override
//	public List<Customer> listCustomer() 
//	{
//		List<Customer> list = new ArrayList<Customer>();
//		Connection connection = null;
//		Statement statement = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			connection = datasource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try 
//		{
//			statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from Customerspring");
//			while (rs.next()) {
//				Customer c = new Customer(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"));
//				list.add(c);
//			}
//		}
//
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return list;
//
//	}
	
	
	
	
	//----------------------------------Using jdbc template-------------------------//
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createCustomer(Customer customer) 
	{
		jdbcTemplate.update("insert into customerspring(firstname, lastname, email) values(?, ?, ?)", customer.getFirstname(), customer.getLastname()
				, customer.getEmail());
	}
	
	
	public void updateCustomer(String firstname, String lastname, String  email)
	{
		int id = 14;
		jdbcTemplate.update("update customerspring set firstname =?, lastname = ?, email= ? where id=?", firstname, lastname, email , id);
		System.out.println("Updated the details");
	}
	
	public void deleteCustomer() 
	{
		int id = 19;
		jdbcTemplate.update("delete from customerspring where id = ?", id);
	}
	
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select firstname,lastname,email from customerspring", new CustomerMapper());
	}
	
	


	
}
