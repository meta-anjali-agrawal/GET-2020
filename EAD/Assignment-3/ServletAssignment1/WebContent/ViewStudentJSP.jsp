<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Student</title>
		<link rel="stylesheet" href="ViewStudentStyles.css">
	</head>
	<body>
		<%
			if(Integer.parseInt(request.getParameter("status")) == 1){
		%>
		<div>
			<form action="ViewStudentServlet" method="post">
				Class
				<select class="select" name="classOfStudent">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
				<input class="input-button" type="submit" value="Submit">
			</form>
			<br>
		</div>
		<%}
		
		%>
		<div>
		
		<%
		ResultSet result = (ResultSet)request.getAttribute("students");
		if(!result.next())
		{
		%>
		
		<h1>No Student Found</h1>
		
		<%
		}
		else
		{
			result.beforeFirst();
		%>
		
			<table style="width:100%">
				<tr>
					<th>S. No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Father's Name</th>
					<th>Email</th>
					<th>Class</th>
					<th>Age</th>
					<th></th>
				</tr>
				
				<%
				while(result.next())
				{
					//if(result.getRowId("class"))
				%>
				
				<tr>
					<td><%=result.getString("idstudentDetails") %></td>
					<td><%=result.getString("firstName") %></td>
					<td><%=result.getString("lastName") %></td>
					<td><%=result.getString("fatherName") %></td>
					<td><%=result.getString("email") %></td>
					<td><%=result.getString("class") %></td>
					<td><%=result.getInt("age") %></td>
					<td><a href="EditStudentServlet?idstudentDetails=<%=result.getInt("idstudentDetails") %>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
			<%
			}
			%>
			<div>
				<table>
					<tr>
						<th><a href="addStudentDetail.html">Add Student Details</a></th>
						<th><a href="SearchStudent.html">Search Student</a></th>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>