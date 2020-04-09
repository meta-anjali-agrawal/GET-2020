<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.parking.pojo.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Edit</title>
    <link href="parking.css" rel="stylesheet"></link>
    <link href="global.css" rel="stylesheet"></link>
	<script type="text/javascript" src="employeeValidation.js"></script>
	<script type="text/javascript" src="passwordValidation.js"></script>
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
		<div class="employee-registration-container">
			<a href="employeeHome.jsp">Home</a>
			<a href="EmployeeLogOutController">Log-Out</a>
		    <div id="add-employee" class="add-employee">
		        <h1 class="M0">EMPLOYEE DETAILS</h1>
		        <form id="employee-details-form" autocomplete="off" action="EditEmployeeDetailsController" method="post" onsubmit="return employeeRegistration()">
		            <div class="form-label-input-container">
		            	<div class="input-data">
		                    <label class="form-label">Employee Id</label>
		                    <input class="form-control disable-field" type="text" value="<%=employee.getEmpId()%>" id="empId" name="empId" readonly autofocus required>
		                    <br/>
		                </div>
		                <div class="input-data">
		                    <label class="form-label">Full Name</label>
		                    <input class="form-control" value="<%=employee.getFullName()%>" id="FullName" type="text" name="FullName" placeholder="Enter Full Name" autofocus required>
		                    <br/>
		                    <span class="validation-message" id='invalidName'></span>
		                </div>
		                <div class="input-data">
		                    <label class="form-label">Gender</label>
		                    <label><input id="Gender" type="radio" name="Gender" value="Male" <%if("Male".equals(employee.getGender())){%>
		                    	checked<%} %> autofocus required class="form-control radio-btn M0">&nbsp; Male</label>
		                    <label><input id="Gender" type="radio" name="Gender" value="Female"  <%if("Female".equals(employee.getGender())){%>
		                    	checked<%} %> autofocus required class="form-control radio-btn M0">&nbsp; Female</label>
		                    <label><input id="Gender" type="radio" name="Gender" value="Other"  <%if("Other".equals(employee.getGender())){%>
		                    	checked<%} %> autofocus required class="form-control radio-btn M0">&nbsp; Other</label>
		                </div>
		                <div class="input-data">
		                    <label class="form-label">Email</label>
		                    <input class="form-control disable-field" value="<%=employee.getEmail()%>" id="Email" type="text" name="Email" placeholder="Enter Email" autofocus required readonly>
		                    <br/>
		                    <span class="validation-message" id='invalidEmail'></span>
		                </div>
		                <div class="input-data">
		                    <label class="form-label">Contact Number</label>
		                    <span>+91</span>
		                    <input class="form-control form-control-contact" value="<%=employee.getContact()%>" id="Contact" type="text" name="Contact" placeholder="Enter Contact Number" autofocus required>
		                    <br/>
		                    <span class="validation-message" id='invalidContact'></span>
		                </div>
		                <div class="input-data">
		                    <label class="form-label">Organization</label>
		                    <select id="Organization" value="<%=employee.getOrganization()%>" name="Organization" class="form-control form-control-organization" required>
		                        <option value="M1">M1</option>
		                        <option value="M2">M2</option>
		                        <option value="M3">M3</option>
		                    </select>&nbsp
		                </div>
		                <div class="input-data">
		                    <input class="employee-details-form-submit" id="Submit" type="submit" value="Edit">
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