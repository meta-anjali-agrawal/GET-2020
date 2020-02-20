<%@page import="com.parking.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.parking.pojo.Vehicle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pass</title>
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
		Vehicle vehicle = (Vehicle)request.getAttribute("vehicle");
		vehicle.setVehicleId(EmployeeDao.getVehicleId(vehicle.getEmpId()));
		System.out.println("hello"+vehicle.getVehicleId());
	%>
	<div class="employee-profile-container">
		<a href="employeeHome.jsp">Home</a>
		<a href="EmployeeLogOutController">Log-Out</a>
		<div class="employee-profile-inner-container">
			<h1 class="M0">PASS DETAILS</h1>
			<label class="form-label">Vehicle Id</label>
			<label class="form-data"><%=vehicle.getVehicleId()%></label><br>
			<label class="form-label">Vehicle Name</label>
			<label class="form-data"><%=vehicle.getVehicleName()%></label><br>
			<label class="form-label">Vehicle Type</label>
			<label class="form-data"><%=vehicle.getVehicleType()%></label><br>
			<label class="form-label">Vehicle Number</label>
			<label class="form-data"><%=vehicle.getVehicleNum()%></label><br>
			<label class="form-label">Identity</label>
			<label class="form-data"><%=vehicle.getVehicleIdentity()%></label><br>
			<label class="form-label">Pass Type</label>
			<label class="form-data"><%=vehicle.getPassType()%></label><br>
			<label class="form-label">Total Price</label>
			<label class="form-data">$ <%=vehicle.getPrice()%></label><br>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>