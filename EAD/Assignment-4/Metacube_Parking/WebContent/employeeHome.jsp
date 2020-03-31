<%@page import="com.parking.dao.EmployeeDao"%>
<%@page import="com.parking.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Page</title>
	<link href="homePage.css" rel="stylesheet">
</head>
<body>
	<div class="home-page-div">
		<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("Email") == null) {
			response.sendRedirect("login.jsp");
		}
		else{
			int empId = EmployeeDao.getEmployeeId(session.getAttribute("Email").toString());
			Employee employee = EmployeeDao.getEmployeeDetails(empId);
		%>
		<a class="employee-profile" href="ViewEmployeeProfileController?empId=<%=employee.getEmpId()%>" >Hello <%=employee.getFullName()%></a>
        <a class="employee-profile-logout" href="EmployeeLogOutController">Log-Out</a>
        <a href="vehicleRegistration.jsp">1. Add vehicle Details</a><br>
       	<a href="ViewFriendsController?empId=<%=empId%>">2. Friends</a><br>
       	<a href="EditEmployeeDetailsController?empId=<%=empId%>">3. Edit Details</a>
		<%
		}
		%>
	</div>
</body>
</html>