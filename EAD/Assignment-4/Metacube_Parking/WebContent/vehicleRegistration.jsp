<%@page import="com.parking.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vehicle Details</title>
	<link href="parking.css" rel="stylesheet"></link>
    <link href="global.css" rel="stylesheet"></link>
    <script type="text/javascript" src="vehicleValidation.js"></script>
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
	<div class="vehicle-registration-container">
		<a href="employeeHome.jsp">Home</a>
		<a href="EmployeeLogOutController">Log-Out</a>
		<div id="employee-registered-message" class="employee-registered-message">
		    <span id="registered" class="registered-message"></span>
		</div>
		<div id="add-vehicle-form" class="add-vehicle-form">
		    <h1>VEHICLE DETAILS</h1>
		    <form id="vehicle-details-form" onsubmit="return vehicleRegister()" action="VehicleRegisterController" method="post">
		        <div class="form-label-input-container">
		            <div class="input-data">
		                <label class="form-label">Vehicle Name</label>
		                <input class="form-control" id="vehicleName" type="text" name="vehicleName" placeholder="Enter Vehicle Name" autofocus required>
		                <br/>
		                <span class="validation-message" id='invalidVehicleName'></span>
		            </div>
		            <div class="input-data">
		                <label class="form-label">Vehicle Type</label>
		                <select id="vehicleType" name="vehicleType" class="form-control form-control-vehicle-type" required>
		                    <option value="none" disabled selected>Select Vehicle Type</option>
		                    <option value="Cycle">Cycle</option>
		                    <option value="MotorCycle">Motor Cycle</option>
		                    <option value="FourWheelers">Four Wheelers</option>
		                </select>&nbsp
		                <br/>
		                <span class="validation-message" id='invalidType'></span>
		            </div>
		            <div class="input-data">
		                <label class="form-label">Vehicle Number</label>
		                <input class="form-control" id="vehicleNumber" type="text" name="vehicleNumber" placeholder="Enter Vehicle Number" autofocus required>
		            </div>
		            <br/>
		            <span class="validation-message" id='invalidVehicleNumber'></span>
		            <div class="input-data">
		                <label class="form-label">Employee Id</label>
		                <input class="form-control disable-field" id="employeeId" type="text" value="<%=employeeId %>" name="employeeId" readonly>
		            </div>
		            <div class="input-data">
		                <label class="form-label">Identification</label>
		                <textarea id="identification" name="identification" placeholder="Vehicle Identification details" rows="4" cols="50" autofocus required></textarea>
		                <br/>
		                <span class="validation-message" id='invalidIdentity'></span>
		            </div>
		            <div class="vehicle-details-form-buttons">
		                <input class="vehicle-details-form-submit-buttons" id="Submit" type="submit" value="Add Vehicle" onclick="vehicleRegister()">
		            </div>
		        </div>
		    </form>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>