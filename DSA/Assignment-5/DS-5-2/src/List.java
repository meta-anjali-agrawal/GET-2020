/**
 * This class sorts the Employee by their Salary
 * @author Anjali
 *
 */
public class List 
{
	
	Employee head = null;
	Employee sort = null;
	
	/**
	 * To add new Employee in list
	 * @param name, employee name.
	 * @param salary, employee salary.
	 * @param age, age of employee.
	 */
	void addEmployee(String name, long salary, int age)
	{
		Employee newEmp = new Employee(name, salary, age);

		if(head == null)
		{
			head = newEmp;
		}
		else{
			Employee employee = head;
			while(employee.next != null)
			{
				employee = employee.next;
			}
			employee.next = newEmp;
		}
	}
	
	/**
	 * To display the linked list
	 * @param head
	 */
	private void display(Employee head) 
	{
		Employee emp = head;
		while(emp != null)
		{
			System.out.println(emp.toString());
			emp = emp.next;
		}

	}

	/**
	 * To display unsorted employee list 
	 */
	public void displayUnSortedList() 
	{
		display(head);
	}

	/**
	 *To sort the list of Employees
	 */
	public void sort()
	{
		sort = null;
		Employee current = head;
		while(current != null)
		{
			Employee next = current.next;
			addToSortedList(current);
			current = next;
		}
	}
	
	/**
	 * To compare two employee
	 * @param node1 is first employee
	 * @param node2 is the second employee
	 * @return true or false
	 */
	private boolean compare(Employee employee1,Employee employee2)
	{
		if(employee1.salary < employee2.salary || (employee1.salary == employee2.salary && employee1.age > employee2.age))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * To add Employee to sorted List
	 * @param node
	 */
	private void addToSortedList(Employee node)
	{
		if(sort == null || compare(sort, node))
		{
			node.next = sort;
			sort = node;
		}
		else
		{
			Employee current = sort;
			while(current.next != null && compare(node,current.next))
			{
				current = current.next;
			}

			node.next = current.next;
			current.next = node;
		}
	}

	/**
	 * To display sorted employee list 
	 */
	public void displaySortedList() 
	{
		sort();
		display(sort);
	}
	
	public static void main(String args[]) 
	{
		List list = new List();
		list.addEmployee("A", 200, 23);
		list.addEmployee("B", 475, 52);
		list.addEmployee("C", 350, 41);
		list.addEmployee("D", 200, 27);
		list.addEmployee("E", 600, 31);
		list.displayUnSortedList();
		System.out.println("Sorted List: ");
		list.displaySortedList();
	}

}
