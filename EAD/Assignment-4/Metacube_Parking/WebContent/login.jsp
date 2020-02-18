<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Login</title>
	<link href="global.css" rel="stylesheet"></link>
	<link href="login.css" rel="stylesheet"></link>
</head>
<body>
	<div class="employee-home-page-container">
		<div class="login-form-container">
			<h2 class="M0">Employee Login</h2>
			<form class="metacube-parking-form" method="post" action="EmployeeLoginController">
				<input id="Email" type="text" name="email" placeholder="Email" autofocus class="form-control" required>
				<input id="Password" type="password" name="password" placeholder="Password"  class="form-control" required>
				<% 
				if(request.getAttribute("message") != null){
				%>
					<p class="login-error M0"><%=request.getAttribute("message")%></p>
				<% }
				%>
				<div class="submit-button-container">
					<input class="form-submit-button" type="submit" value="Login">
				</div>
				<span class="create-a-account"> Don't have an account? &nbsp
					<a href="signUp.jsp">Sign-Up</a>
				</span>
			</form>
		</div>
	</div>
</body>
</html>