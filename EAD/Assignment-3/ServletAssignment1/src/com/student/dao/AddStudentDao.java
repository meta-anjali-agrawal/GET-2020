package com.student.dao;

import com.student.pojo.Student;

import java.sql.*;

import com.student.dbConnections.*;

public class AddStudentDao 
{
	public static int save(Student student)
	{
		int status = 0;
		int emailExists = 0;
		try
		{
			Connection conn = dbConnection.getConnection();
			Statement statement = conn.createStatement();
			String email = student.getEmail();
			String sqlStatement = "SELECT Count(*) FROM StudentDetails WHERE email=\"" + email + "\"";
			ResultSet rs = statement.executeQuery(sqlStatement);

			while(rs.next())
			{
				emailExists = rs.getInt(1);
			}

			if(emailExists == 0)
			{
				PreparedStatement ps = conn.prepareStatement("Insert into StudentDetails(idstudentDetails, firstName, lastName, fatherName, email, class, age) values(idstudentDetails,?,?,?,?,?,?)");
				ps.setString(1,student.getFirstName());
				ps.setString(2,student.getLastName());
				ps.setString(3,student.getFatherName());
				ps.setString(4,student.getEmail());
				ps.setString(5,student.getClassOfStudent());
				ps.setInt(6,student.getAge());
				status = ps.executeUpdate();
				conn.close();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
