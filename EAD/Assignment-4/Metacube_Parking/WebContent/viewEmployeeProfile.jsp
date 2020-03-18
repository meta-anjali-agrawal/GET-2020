<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.parking.pojo.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Profile</title>
	<link href="parking.css" rel="stylesheet"></link>
    <link href="global.css" rel="stylesheet"></link>
    <link href="viewFriends.css" rel="stylesheet"></link>
</head>
<body>
	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Email") == null) {
		response.sendRedirect("login.jsp");
	} 
	else {
		Employee employee = (Employee)request.getAttribute("employee");
	%>
	<div class="employee-profile-container">
		<a href="employeeHome.jsp">Home</a>
		<a href="EmployeeLogOutController">Log-Out</a>
		<div class="employee-profile-inner-container">
			<h1 class="M0">EMPLOYEE PROFILE</h1>
			<label class="form-label">Employee Id</label>
			<label class="form-data"><%=employee.getEmpId()%></label><br>
			<label class="form-label">Full Name</label>
			<label class="form-data"><%=employee.getFullName()%></label><br>
			<label class="form-label">Email</label>
			<label class="form-data"><%=employee.getEmail()%></label><br>
			<label class="form-label">Gender</label>
			<label class="form-data"><%=employee.getGender()%></label><br>
			<label class="form-label">Contact</label>
			<label class="form-data"><%=employee.getContact()%></label><br>
			<label class="form-label">Organization</label>
			<label class="form-data"><%=employee.getOrganization()%></label><br>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>