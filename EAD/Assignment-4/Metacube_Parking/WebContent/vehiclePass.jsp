<%@page import="com.parking.pojo.Vehicle"%>
<%@page import="com.parking.dao.EmployeeDao"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vehicle Pass</title>
	<link href="parking.css" rel="stylesheet"></link>
	<link href="global.css" rel="stylesheet"></link>
	<script type="text/javascript" src="passValidation.js"></script>
</head>
<body>
	<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Email") == null) {
			response.sendRedirect("login.jsp");
	}
	else{
	int employeeId = EmployeeDao.getEmployeeId(session.getAttribute("Email").toString());
	%>
	<div class="pass-container">
		<a href="employeeHome.jsp">Home</a>
		<a href="EmployeeLogOutController">Log-Out</a>
		<div class="vehicle-Price-div" id="vehicle-Price-div">
		    <h1>PRICE DETAILS</h1>
		    <form class="vehicle-Price-form" onsubmit="return takeGetPass()" id="vehicle-Price-form" action="VehiclePassController" method="post">
		        <table class="price-table" align="center" cellspacing="10" cellpadding="20">
		            <tr class="price-content-type" id="price-content-type" style="display: block;">
		                <th class="content-type-header">
		                    <h3>Type</h3>
		                </th>
		                <th class="content-type-header">
		                    <h3>Daily</h3>
		                </th>
		                <th class="content-type-header">
		                    <h3>Monthly</h3>
		                </th>
		                <th class="content-type-header">
		                    <h3>Yearly</h3>
		                </th>
		            </tr>
					<%
					Vehicle vehicle = (Vehicle)request.getAttribute("vehicle");
					if(vehicle.getVehicleType().equals("Cycle")){
					%>
		            <tr class="table-data" id="Cycle" style="display: block;">
		                <th class="content-name">
		                    <h4>Cycle</h4>
		                </th>
		                <td><input class="form-control p" value="5D" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">5</p>
		                </td>
		                <td><input class="form-control p" value="100M" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">100</p>
		                </td>
		                <td><input class="form-control p" value="500Y" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">500</p>
		                </td>
		            </tr>
					<%}
					else if(vehicle.getVehicleType().equals("MotorCycle")){
					%>
		            <tr class="table-data" id="MotorCycle" style="display: block;">
		                <th class="content-name">
		                    <h4>Motor Cycle</h4>
		                </th>
		                <td><input class="form-control p" value="10D" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">10</p>
		                </td>
		                <td><input class="form-control p" value="200M" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">200</p>
		                </td>
		                <td><input class="form-control p" value="1000Y" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">1000</p>
		                </td>
		            </tr>
					<% 
					}
					else if(vehicle.getVehicleType().equals("FourWheelers")){
					%>
		            <tr class="table-data" id="FourWheelers" class="p">
		                <th class="content-name">
		                    <h4>Four Wheelers</h4>
		                </th>
		                <td><input class="form-control p" value="20D" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">20</p>
		                </td>
		                <td><input class="form-control p" value="500M" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">500</p>
		                </td>
		                <td><input class="form-control p" value="3500Y" type="radio" name="price"><span class="sign">USD</span>
		                    <p class="money">3500</p>
		                </td>
		            </tr>
					<% 
					} 
					%>
		            <tr id="button" style="display: block;">
		                <th><button class="form-control" type="submit">Generate Pass</button></th>
		                <th>
		                    <select id="price" onchange="changeCurrency()">
		                        <option disabled selected>Change Currency</option>
		                        <option value="USD">USD</option>
		                        <option value="YEN">YEN</option>
		                        <option value="INR">INR</option>
		                    </select>
		                </th>
		                <th class="error-message" id="error-message"></th>
		            </tr>
		        </table>
		        <input type="hidden" name="vehicleName" value="<%=vehicle.getVehicleName()%>">
				<input type="hidden" id="vehicleType" name="vehicleType" value="<%=vehicle.getVehicleType()%>">
				<input type="hidden" name="vehicleNumber" value="<%=vehicle.getVehicleNum()%>">
				<input type="hidden" name="employeeId" value="<%=vehicle.getEmpId()%>">
				<input type="hidden" name="identification" value="<%=vehicle.getVehicleIdentity()%>">		  
		    </form>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>