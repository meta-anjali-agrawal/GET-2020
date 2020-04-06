<%@ page import="java.util.ArrayList"%>
<%@ page import="com.parking.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="viewFriends.css" rel="stylesheet">
	<title>View Friends</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Email") == null) {
		response.sendRedirect("login.jsp");
	} 
	else {
	%>
	<table align="center">
		<tr>
			<th><a href="employeeHome.jsp">Home</a></th>
			<th><a href="EmployeeLogOutController">Log-Out</a></th>
		</tr>
		<tr>
			<th>Employee Id</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Contact</th>
			<th>Organization</th>
			<th>Action</th>
			</th>
		</tr>
		<h2 align="center">FRIENDS DETAILS</h2>
		<%
		ArrayList<Employee> friendsList = (ArrayList)request.getAttribute("friendsList");
			if (friendsList.isEmpty()) {
		%>
		<tr>
			<td colspan="8" class="no-data">No Data Found</td>
		</tr>
		<%
			} else {
				 for (Employee employee : friendsList) { 		      
		%>
		<tr>
			<td><%=employee.getEmpId()%></td>
			<td><%=employee.getFullName()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getGender()%></td>
			<td><%=employee.getContact()%></td>
			<td><%=employee.getOrganization()%></td>
			<td><a href="ViewEmployeeProfileController?empId=<%=employee.getEmpId()%>">View Profile</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<% 
	}
	%>

</body>
</html>
