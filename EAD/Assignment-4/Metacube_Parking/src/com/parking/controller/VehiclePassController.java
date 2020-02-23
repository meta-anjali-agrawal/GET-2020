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
@WebServlet("/VehiclePassController")
public class VehiclePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     * VehiclePassController servlet constructor
     */
    public VehiclePassController() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * VehiclePassController servlet Post method for getting pass details from pass form.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String priceAndPlan = request.getParameter("price").toString();
		String[] part = priceAndPlan.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		String passType = "";
		if(part[1].equals("D")){
			passType = "Daily";
		}
		else if(part[1].equals("M")){
			passType = "Monthly";
		}
		else if(part[1].equals("Y")){
			passType = "Yearly";
		}
		int price = Integer.parseInt(part[0]);
		String vehicleName = request.getParameter("vehicleName");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleNumber = request.getParameter("vehicleNumber");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String identification = request.getParameter("identification");
		Vehicle vehicle = new Vehicle();
		vehicle.setPassType(passType);
		vehicle.setPrice(price);
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleType(vehicleType);
		vehicle.setVehicleNum(vehicleNumber);
		vehicle.setEmpId(employeeId);
		vehicle.setVehicleIdentity(identification);
		EmployeeDao.saveVehicleDetails(vehicle);
		request.setAttribute("vehicle", vehicle);
		request.getRequestDispatcher("pass.jsp").include(request, response);
	}
}
