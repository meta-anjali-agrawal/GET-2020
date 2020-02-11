package com.parking.pojo;
/**
 * 
 * @author Anjali
 * POJO class for vehicle details.
 */
public class Vehicle {
	private int empId, vehicleId, price;
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	private String vehicleName, vehicleType, vehicleNumber, vehicleIdentity, passType;
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNum() {
		return vehicleNumber;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNumber = vehicleNum;
	}

	public String getVehicleIdentity() {
		return vehicleIdentity;
	}

	public void setVehicleIdentity(String vehicleIdentity) {
		this.vehicleIdentity = vehicleIdentity;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
