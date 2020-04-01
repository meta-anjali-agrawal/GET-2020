import java.util.Comparator;


public class EmpSortById implements Comparator<Employee>
{
	public int compare(Employee emp1, Employee emp2) {

		if (emp1.getEmpId() < emp2.getEmpId()) 
		{
			return -1;
		}
		else if (emp1.getEmpId() > emp2.getEmpId())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
}
