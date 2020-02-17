package com.student.dao;

import java.sql.*;
import com.student.dbConnections.dbConnection;

public class ViewStudentDao
{
	private ResultSet student = null;
	
	public ResultSet viewStudent()
	{
		try
		{
			Connection conn = dbConnection.getConnection();
			Statement statement = conn.createStatement();
			String sqlQuery = "SELECT * FROM studentDetails";
			student = statement.executeQuery(sqlQuery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}
	
	public ResultSet classFilter(String filterClass)
	{
		try
		{
			Connection conn = dbConnection.getConnection();
			Statement statement = conn.createStatement();
			String sqlQuery = "SELECT * FROM studentDetails WHERE class = '" + filterClass + "'";
			student = statement.executeQuery(sqlQuery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}
}
