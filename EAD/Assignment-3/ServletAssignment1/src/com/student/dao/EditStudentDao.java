package com.student.dao;

import java.sql.*;
import com.student.pojo.*;
import com.student.dbConnections.*;

public class EditStudentDao 
{
	public static void getDetail(Student student)
	{
		try
		{
			Connection conn = dbConnection.getConnection();
			Statement statement = conn.createStatement();
			int id = student.getStudentId();
			String query = "SELECT * FROM studentDetails WHERE idstudentDetails="+id+"";
			ResultSet result = statement.executeQuery(query);
			while(result.next())
			{
				student.setFirstName(result.getString("firstName"));
				student.setLastName(result.getString("lastName"));
				student.setFatherName(result.getString("fatherName"));
				student.setEmail(result.getString("email"));
				student.setClassOfStudent(result.getString("class"));
				student.setAge(result.getInt("age"));
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void save(Student student)
	{
		try
		{
			Connection conn = dbConnection.getConnection();
			String query = "Update studentDetails SET firstName=? , lastName=? , fatherName=? , email=? , class=? , age=? WHERE idstudentDetails=?";
			PreparedStatement result = conn.prepareStatement(query);
			result.setString(1, student.getFirstName());
			result.setString(2, student.getLastName());
			result.setString(3, student.getFatherName());
			result.setString(4, student.getEmail());
			result.setString(5, student.getClassOfStudent());
			result.setInt(6, student.getAge());
			result.setInt(7, student.getStudentId());
			result.executeUpdate();
			conn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
