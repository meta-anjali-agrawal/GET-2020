package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.pojo.Student;
import com.student.dao.*;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student Details</title>");
		out.println("</head>");
		out.println("<body>");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classOfStudent = request.getParameter("classOfStudent");
		int age = Integer.parseInt(request.getParameter("age"));

		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setFatherName(fatherName);
		student.setEmail(email);
		student.setClassOfStudent(classOfStudent);
		student.setAge(age);
		int status = AddStudentDao.save(student);
		if(status == 1)
		{
			out.println("<script>alert('Congratulations! " + firstName + " Added Successfully.')</script>");
			status=2;
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else if(status == 0)
		{
			out.println("<script>alert('Sorry! Email id already exists.')</script>");
			request.getRequestDispatcher("addStudentDetail.html").include(request, response);;
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
