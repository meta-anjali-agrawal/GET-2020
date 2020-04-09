<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.student.pojo.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Details</title>
		<link rel="stylesheet" href="addStudentDetailsStyles.css">
		<script src="addStudentJS.js"></script>
	</head>
	<body>
		<div>
		<form action="EditStudentServlet" method="post" onsubmit="return register()">
			<div>
				<fieldset>
				
					<legend>Edit Student Details</legend>
					
					<%
						Student student = (Student)request.getAttribute("student");
					%>
					
					<div>
						<input id="studentId" type="hidden" name="idstudentDetails" value="<%=student.getStudentId()%>" readonly/>
					</div>
					
					<div class="form1">
					First Name:
						<input type="text" class="form1" id="fname" name="firstName" value="<%=student.getFirstName()%>">
					</div><br>
					
					<div class="form1">
					Last Name:
						<input type="text" class="form1" id="lname" name="lastName" value="<%=student.getLastName()%>">
					</div><br>
					
					<div class="form1">
					Father's Name:
						<input type="text" class="form1" id="father_name" name="fatherName" value="<%=student.getFatherName()%>">
					</div><br>
					
					<div class="form1">
					Email Id:
						<input type="email" class="form1" id="email" name="email" value="<%=student.getEmail()%>" readonly>
					</div><br>
					
					<div class="form1">
					Class:
						<input type="text" class="form1" id="class" name="class" value="<%=student.getClassOfStudent()%>">
					</div><br>
					
					<div class="form1">
					Age:
						<input type="number" class="form1" id="age" name="age" value="<%=student.getAge()%>">
					</div><br>
					
					<div>
						<input class="input-button" type="submit" value="Submit">
					</div>
					
				</fieldset>
			</div>
		</form>
		</div>
		
		<div>
		<table>
			<tr>
				<th><a href="addStudentDetail.html">Add Student Details</a></th>
				<th><a href="ViewStudentServlet">Show all Students</a></th>
				<th><a href="SearchStudent.html">Search Student</a></th>
			</tr>
		</table>
		</div>
	</body>
</html>