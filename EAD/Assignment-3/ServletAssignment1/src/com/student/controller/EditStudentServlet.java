package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.pojo.*;
import com.student.dao.*;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idstudentDetails"));
		Student student = new Student();
		student.setStudentId(id);
		EditStudentDao.getDetail(student);
		request.setAttribute("student", student);
		request.getRequestDispatcher("EditStudentJSP.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Detailst</title>");
		out.println("</head>");
		out.print("<body>");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classOfStudent = request.getParameter("class");
		int age =Integer.parseInt(request.getParameter("age"));
		int studentId = Integer.parseInt(request.getParameter("idstudentDetails"));
		
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setFatherName(fatherName);
		student.setEmail(email);
		student.setClassOfStudent(classOfStudent);
		student.setAge(age);
		EditStudentDao.save(student);
		out.println("<script>alert('Yeah!! Your data edited Successfully!')</script>");
		request.getRequestDispatcher("index.html").include(request, response);  
		
		out.print("<br"
				+ "></body>");
		out.print("</html>");
		out.close(); 
	}

}
