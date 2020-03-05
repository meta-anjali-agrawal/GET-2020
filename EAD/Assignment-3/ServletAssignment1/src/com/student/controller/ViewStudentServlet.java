package com.student.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.ViewStudentDao;

/**
 * Servlet implementation class ViewStudentServlet
 */
@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet viewStudent =new ViewStudentDao().viewStudent();
		request.setAttribute("students", viewStudent);
		request.getRequestDispatcher("ViewStudentJSP.jsp?status=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stdClass = request.getParameter("classOfStudent");
		ResultSet viewStudent =new ViewStudentDao().classFilter(stdClass);
		request.setAttribute("students", viewStudent);
		request.getRequestDispatcher("ViewStudentJSP.jsp?status=1").forward(request, response);
	}

}
