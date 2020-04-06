
public class EmployeeList
{
	
	Employee head = null;
	Employee sortedList = null;

	/**
	 * To add new Employee in list
	 * @param name 
	 * @param salary 
	 * @param age 
	 */
	public void addEmployee(String name, long salary, int age)
	{
		Employee newEmployee = new Employee(name, salary, age);

		if(head == null)
		{
			head = newEmployee;
		}
		else
		{
			Employee employee = head;
			while(employee.getNext() != null)
			{
				employee = employee.getNext();
			}
			employee.setNext(newEmployee);
		}
	}


	/**
	 * To display the linked list
	 */
	private void displayList()
	{
		Employee emp = head;
		while(emp != null)
		{
			System.out.println(emp.toString());
			emp = emp.getNext();
		}
	}
	
	/**
	 * To partition list on basis of pivot point
	 * @param start header of list
	 * @param end last node of list
	 * @return pivot
	 */
	private Employee partitionLast(Employee start, Employee end) 
	{ 
		if(start == end || start == null || end == null) 
			return start; 

		Employee pivot_prev = start; 
		Employee curr = start;  
		Employee pivot = end;  

		while(start != end ) 
		{ 
			if(start.getSalary() > pivot.getSalary()) 
			{  
				pivot_prev = curr;  
				long tempSal = curr.getSalary();  
				curr.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = curr.getName();
				curr.setName(start.getName());
				start.setName(tempName);

				int tempAge = curr.getAge();
				curr.setAge(start.getAge());
				start.setAge(tempAge);
				curr = curr.getNext();  
			}
			else if(start.getSalary() == pivot.getSalary() && start.getAge() < pivot.getAge()) 
			{    
				long tempSal = pivot.getSalary();  
				pivot.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = pivot.getName();
				pivot.setName(start.getName());
				start.setName(tempName);

				int tempAge = pivot.getAge();
				pivot.setAge(start.getAge());
				start.setAge(tempAge);  
			}

			start = start.getNext();  
		} 
		long tempSal = curr.getSalary();  
		curr.setSalary(pivot.getSalary());  
		end.setSalary(tempSal); 

		String tempName = curr.getName();
		curr.setName(end.getName());
		end.setName(tempName);

		int tempAge = curr.getAge();
		curr.setAge(end.getAge());
		end.setAge(tempAge);

		curr = curr.getNext();
		return pivot_prev; 
	} 

	/**
	 * To sort the employee list in descending order.
	 * @param start header of list
	 * @param end last index of list
	 */
	void quickSort(Employee start, Employee end) 
	{ 
		if(start == end ) 
			return; 

		Employee pivot_prev = partitionLast(start, end); 
		quickSort(start, pivot_prev); 

		if( pivot_prev != null && pivot_prev == start ) 
			quickSort(pivot_prev.getNext(), end); 
		else if(pivot_prev != null && pivot_prev.getNext() != null) 
			quickSort(pivot_prev.getNext().getNext(), end); 
	}
	
	/**
	 * To get the last node in employee list
	 * @return last node of employee list.
	 */
	private  Employee getLastElement()
	{
		Employee employee = head;
		while(employee.getNext()!=null)
		{
			employee = employee.getNext();
		}
		return employee;
	}
	
	/**
	 * To sort employee list in descending order of there salary
	 * if two employees have same salary then smaller age employee comes first
	 */
	void sortList()
	{
		quickSort(head, getLastElement());
	}

	public static void main(String[] args)
	{
		EmployeeList list = new EmployeeList();
		list.addEmployee("A", 200, 23);
		list.addEmployee("B", 475, 52);
		list.addEmployee("C", 350, 41);
		list.addEmployee("D", 200, 27);
		list.addEmployee("E", 600, 31);
		list.displayList();
		list.sortList();
		System.out.println("Sorted List: ");
		list.displayList();
	}
	
}
