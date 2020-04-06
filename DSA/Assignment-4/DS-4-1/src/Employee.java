/**
 * Employee POJO class
 * @author Anjali
 *
 */
public class Employee 
{
	
	private int empId;
	private String empName;
	private String empAddress;
	
	/**
	 * Initialize Employee
	 * @param id , employee id
	 * @param name, employee name
	 * @param address, employee address
	 */
	Employee(int id, String name, String address)
	{
		empId = id;
		empName = name;
		empAddress = address;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
