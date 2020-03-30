package com.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dao.EmployeeDao;
import com.parking.pojo.Vehicle;
/**
 * 
 * @author Anjali
 */
@WebServlet("/VehicleRegisterController")
public class VehicleRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * VehicleRegisterController servlet constructor
     */
    public VehicleRegisterController() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * VehicleRegisterController servlet Post method for getting vehicle details from vehicle form .
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicleName = request.getParameter("vehicleName");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleNumber = request.getParameter("vehicleNumber");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String identification = request.getParameter("identification");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleType(vehicleType);
		vehicle.setVehicleNum(vehicleNumber);
		vehicle.setEmpId(employeeId);
		vehicle.setVehicleIdentity(identification);
		request.setAttribute("vehicle", vehicle);
		request.getRequestDispatcher("vehiclePass.jsp").forward(request, response);
	}
}
