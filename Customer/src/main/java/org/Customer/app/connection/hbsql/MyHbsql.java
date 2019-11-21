package org.Customer.app.connection.hbsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;


public class MyHbsql 
{
	private static Connection connection = null;
	
	private MyHbsql() throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "pass@word1");
	}
	
	public static Connection getMyConection() throws SQLException
	{
		if(connection == null)
		{
				new MyHbsql();	
		}
		return connection;
	}
}
