package com.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parking.dao.EmployeeDao;
import com.parking.pojo.Employee;
/**
 * 
 * @author Anjali
 * Servlet method for employee registration
 */
@WebServlet("/EmployeeRegistrationController")
public class EmployeeRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * EmpRegController servlet constructor
	 */
	public EmployeeRegistrationController() {
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * EmpRegController servlet Post method for getting all the details of employee registration form
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fullName = request.getParameter("FullName");
		String gender = request.getParameter("Gender");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String contact = request.getParameter("Contact");
		String organization = request.getParameter("Organization");
		
		Employee employee = new Employee();
		employee.setFullName(fullName);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setContact(contact);
		employee.setOrganization(organization);
		int status = EmployeeDao.saveEmployeeDetails(employee);

		if(status == 1){
			HttpSession session=request.getSession();
			session.setAttribute("Email", email);
			response.sendRedirect("employeeHome.jsp");
		}
		else if(status == 2){
			String message = "Email id already exists !!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("signUp.jsp").include(request, response);
		}
		else{
			request.getRequestDispatcher("signUp.jsp").include(request, response);
		}

	}

}
