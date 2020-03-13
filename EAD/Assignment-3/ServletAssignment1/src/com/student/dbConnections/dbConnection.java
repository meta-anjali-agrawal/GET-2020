package com.student.dbConnections;

import java.sql.*;

public class dbConnection 
{
	private static String url = "jdbc:mysql://localhost:3306/Student";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection getConnection()
	{
		Connection connection;
		connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	

}
