import java.util.*;

public class EmployeeOperations 
{
	
	private static ArrayList<Employee> employeeList = new ArrayList<>();
	
	/**
	 * To check the employee which will be added is unique or not
	 * @param empId, employee id of an employee
	 * @return true if unique, else false
	 */
	public static boolean isUniqueEmployee(int empId)
	{
		for(Employee empList : employeeList)
		{
			if(empList.getEmpId() == empId){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To add employee
	 * @param employee, to be added
	 * @throws Exception
	 */
	public static void addEmployee(Employee employee) throws Exception
	{
		if (employee == null) 
		{
			throw new Exception("Null object can not be added.");
		}
		else if(isUniqueEmployee(employee.getEmpId())){
			employeeList.add(employee);
		}
		else
		{
			System.out.println("Employee already added");
		}
	}
	
	/**
	 * To sort by ID
	 * @return, sorted list
	 */
	public static List<Employee> sortByEmpId()
	{
		ArrayList<Employee> sortedList = employeeList;
		Collections.sort(sortedList, new EmpSortById());
		return sortedList;
	}
	
	/**
	 * To sort by Name
	 * @return, sorted list by Name
	 */
	public static List<Employee> sortByEmpName()
	{
		ArrayList<Employee> sortedList = employeeList;
		Collections.sort(sortedList, new EmpSortByName());
		return sortedList;
	}
	
	static void display()
	{			
		for (Employee employee : employeeList)
			System.out.println("Id: " + employee.getEmpId() + ", Employee Name: "+employee.getEmpName() + ", Address: "+ employee.getEmpAddress());
	}
	
	public static void main(String[] args) throws Exception
	{
		Employee emp1 = new Employee(2, "Akanksha", "Jaipur");
		Employee emp2 = new Employee(1, "Aanchal", "Jaipur");
		Employee emp3 = new Employee(4, "Anjali", "Kota");
		Employee emp4 = new Employee(5, "Parul", "Udaipur");
		Employee emp5 = new Employee(3, "Saumya", "Jaipur");
		Employee emp6 = new Employee(3, "Saumya", "Jaipur");
		addEmployee(emp1);
		addEmployee(emp2);
		addEmployee(emp3);
		addEmployee(emp4);
		addEmployee(emp5);
		addEmployee(emp6);
		System.out.println("Employee List:");
		display();
		System.out.println("Sorted by Employee ID:");
		sortByEmpId();
		display();
		System.out.println("Sorted by Employee Name:");
		sortByEmpName();
		display();
	}
	
}
