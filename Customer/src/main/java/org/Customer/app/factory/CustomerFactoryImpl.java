package org.Customer.app.factory;

import java.sql.Connection;
import java.util.Scanner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.Customer.app.connection.hbsql.MyHbsql;
import org.Customer.app.module.Customer;

//import org.Customer.app.connection.hbsql;

import java.util.List;


public class CustomerFactoryImpl implements CustomerFactory
{
	Scanner in = new Scanner(System.in);
	
		private Connection connection = null;
		private PreparedStatement pstatement = null;
		private Statement statement = null;
		
		
		Customer tempCustomer=null;
		public CustomerFactoryImpl()
		{
			super();
			
			try {
				connection = MyHbsql.getMyConection();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		
	public  Customer createCustomer(int id, String name, String email)
	{
	
		try
		{
			tempCustomer=new Customer(id,name,email);
			pstatement = connection.prepareStatement("Insert into CUSTOMER values (?,?,?)");
			pstatement.setInt(1,  tempCustomer.getId());
			pstatement.setString(2,  tempCustomer.getName());
			pstatement.setString(3, tempCustomer.getEmail());
			
			
			/*tempCustomer.setId(id);
			tempCustomer.setName(name);
			tempCustomer.setEmail(email);*/
			
			
			int count = pstatement.executeUpdate();
			System.out.println(count + "rows inserted");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tempCustomer;
	}

	
	

	
	public List<Customer> getAllCustomer() 
	{
	
		List<Customer> list=new ArrayList<Customer>();
		
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from customer");
			while(rs.next())
			{
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(c);
			}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return list;
		
	}



	public void findById(int id) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			int count = -1;
			pstatement = connection.prepareStatement("select * from Customer where id = ?");
			pstatement.setInt(1, id);
			ResultSet rs = pstatement.executeQuery();
			System.out.println(rs);
			
			while(rs.next())
			{
				count++;
			}
			if(count<0)
			{
				System.out.println("no such record found...");
			}
			
			else
			{
				rs.beforeFirst();
				while(rs.next())
				{
					System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				}
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}



	public void deleteCustomer(int id)
	{
		try
		{
			//System.out.println("Enter the ID to be deleted:");
			//int id2 = in.nextInt();
			pstatement = connection.prepareStatement("delete from customer where id = ?");
			pstatement.setInt(1, id);
			
			int i = pstatement.executeUpdate();
			if(i <= 0)
			{
				System.out.println("No such id");
			}
			else
			{
				System.out.println("Deleted successfully");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void updateCustomer(int id) 
	{
		
		try {
			System.out.println("Enter the updated name:");
			String name = in.next();
			System.out.println("Enter the updated email:");
			String email = in.next();
			
			pstatement = connection.prepareStatement("update customer set name = ? , email = ? where id = ?");
			pstatement.setString(1, name);
			pstatement.setString(2,  email);
			pstatement.setInt(3,  id);
				
			int i = pstatement.executeUpdate();
			if(i <= 0)
			{
				System.out.println("No such id");
			}
			else
			{
				System.out.println("Updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	/*public void findByName(String name) {
		try
		{
			int count = -1;
			pstatement = connection.prepareStatement("selct * from Customer where name = ?");
			pstatement.setString(2, name);
			ResultSet rs = pstatement.executeQuery();
			
			while(rs.next())
			{
				count++;
				
			}
			if(count<0)
			{
				System.out.println("no such record found...");
			}
			
			else
			{
				while(rs.next())
				{
					System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				}
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}*/

}
