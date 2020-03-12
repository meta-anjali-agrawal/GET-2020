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
 */
@WebServlet("/ViewEmployeeProfileController")
public class ViewEmployeeProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * ViewEmployeeProfileController servlet constructor
     */
    public ViewEmployeeProfileController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)\
	 * ViewEmployeeProfileController servlet Get method for getting employee details from database to frontend.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("Email") == null) {
			response.sendRedirect("login.jsp");
		} 
		else {
			int empId = Integer.parseInt(request.getParameter("empId"));
			Employee employee = EmployeeDao.getEmployeeDetails(empId);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("viewEmployeeProfile.jsp").include(request, response);
		}
	}
}
