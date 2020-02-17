package com.employee.databaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * @author Anjali
 * Class for implementing a database connection 
 */
public class DbConnection {
	private static DbConnection single_instance = null;
	private static String url = "jdbc:mysql://localhost:3306/parking";
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	/**
	 * 
	 * @return : instance of class if not created previously
	 */
	public static DbConnection getInstance(){
		if (single_instance == null) 
			single_instance = new DbConnection(); 
		return single_instance;
	}
	/**
	 * 
	 * @return : connection object which was created
	 */
	public static Connection getConnection(){
		
		try{
			if(connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,username,password);
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return connection;
	}
}
