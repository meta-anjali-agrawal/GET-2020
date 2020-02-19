package com.student.dao;

import java.sql.*;

import com.student.dbConnections.dbConnection;

public class SearchStudentDao 
{
	Connection conn = dbConnection.getConnection();
	public ResultSet searchStudentByName(String firstName, String lastName, String classFilter) {
		ResultSet students = null;
		String query="";
		try{
			if(firstName.equalsIgnoreCase("") && lastName.equalsIgnoreCase(""))
			{
				query = "SELECT * FROM studentDetails where class='" + classFilter + "'" ;
			}
			else if(firstName.equalsIgnoreCase(""))
			{
				query = "SELECT * FROM studentDetails where lastName=\""+lastName+"\" AND class='" + classFilter + "'" ;
			}
			else if(lastName.equalsIgnoreCase(""))
			{

				query = "SELECT * FROM studentDetails where firstName=\""+firstName+"\" AND class='" + classFilter + "'" ;
			}
			else
			{
				query = "SELECT * FROM studentDetails where firstName=\""+firstName+"\" AND " +"lastName=\""+lastName+"\" AND class='" + classFilter + "'" ;
			}
			PreparedStatement st = conn.prepareStatement(query);
			students = st.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return students;
	}
}
