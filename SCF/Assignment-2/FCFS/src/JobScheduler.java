import java.util.*;

public class JobScheduler 
{
	static List<Integer> completionTime = new ArrayList<Integer>();
	static List<Integer> waitingTime = new ArrayList<Integer>();
	static List<Integer> turnaroundTime = new ArrayList<Integer>();
	static int i, j, cTime, wTime, tTime;
	
	static void sort(int[][] array)
	{
		int tempVariable;
		for(int i=0 ; i<array.length - 1 ; i++)
		{
			for(int j=i+1 ; j<array.length ; j++)
			{
				if(array[i][0]>array[j][0])
				{
					tempVariable = array[i][0];
					array[i][0] = array[j][0];
					array[j][0] = tempVariable;
					
					tempVariable = array[i][1];
					array[i][1] = array[j][1];
					array[j][1] = tempVariable;
				}
			}
		}
	}
	
	static List<Integer> completionTimeMethod(int[][] process)
	{
		//Method to calculate Completion Time of each Process
		cTime = process[0][0] + process[0][1];
		completionTime.add(cTime);
		for(i=1 ; i<process.length ; i++)
		{
			if(process[i][0]<completionTime.get(i-1))
			{
				cTime = completionTime.get(i-1) + process[i][1];
				completionTime.add(cTime);
			}
			else
			{
				cTime = process[i][0] + process[i][1];
				completionTime.add(cTime);
			}
		}
		return completionTime;
	}
	
	static List<Integer> waitingTimeMethod(int[][] process)
	{
		//Method to calculate Waiting Time of each Process
		waitingTime.add(0);
		for(i=1 ; i<process.length ; i++)
		{
			if(process[i][0]<completionTime.get(i-1))
			{
				cTime = completionTime.get(i-1) + process[i][1];
				wTime = completionTime.get(i-1) - process[i][0];
			}
			else
			{
				cTime = process[i][0] + process[i][1];
				wTime = 0;
			}
			waitingTime.add(wTime);
		}
		
		return waitingTime;
	}
	
	static List<Integer> turnaroundTimeMethod(int[][] process)
	{
		//Method to calculate Turnaround Time of each Process
		for(i=0 ; i<process.length ; i++)
		{
			tTime = completionTime.get(i) - process[i][0];
			turnaroundTime.add(tTime);
		}
		return turnaroundTime;
	}
	
	static void averageWaitingTimeMethod(int[][] process)
	{
		//calculating average of waiting time
		int waitTime = 0, maxWaitTime = 0;
		double avgWaitingTime;
		for(i=0 ; i<process.length ; i++)
		{
			waitTime += waitingTime.get(i);
			if(waitingTime.get(i)>maxWaitTime)
			{
				maxWaitTime = waitingTime.get(i);
			}
		}
		avgWaitingTime = waitTime/process.length;
		System.out.println("Average Waiting Time : " + avgWaitingTime);
		System.out.println("Maximum Waiting Time : " + maxWaitTime);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noOfProcess, k;
		List<Integer> completionTime1 = new ArrayList<Integer>();
		List<Integer> waitingTime1 = new ArrayList<Integer>();
		List<Integer> turnaroundTime1 = new ArrayList<Integer>();
		
		System.out.println("Enter number of processes:");
		noOfProcess = sc.nextInt();
		
		if(noOfProcess<=0)
		{
			System.out.println("OOPS!! YOU SHOULD ENTER A POSITIVE NUMBER");
		}
		else
		{
			int[][] process = new int[noOfProcess][2];
			
			System.out.println("Enter Arrival Time and Burst Time of each Process:");
			for(i=0 ; i<noOfProcess ; i++)
			{
				k = i+1;
				System.out.println("Process " + k + " :");
				for(j=0 ; j<2 ; j++)
				{
					if(j==0)
						System.out.println("Arrival Time :");
					else
						System.out.println("Burst Time :");
					
					process[i][j] = sc.nextInt();
				}
				System.out.println();
			}
			System.out.println("Before Sorting:");
			System.out.println("Arrival Time	Burst Time");
			for(i=0 ; i<noOfProcess ; i++)
			{
				System.out.println(process[i][0] + "		" + process[i][1]);
			}
			
			sort(process);
			System.out.println();
			System.out.println("After Sorting:");
			System.out.println("Process Number	Arrival Time	Burst Time");
			for(i=0 ; i<noOfProcess ; i++)
			{
				j = i + 1;
				System.out.println(j + "		" + process[i][0] + "		" + process[i][1]);
			}
			
			completionTime1 = completionTimeMethod(process);
			waitingTime1 = waitingTimeMethod(process);
			turnaroundTime1 = turnaroundTimeMethod(process);
			
			System.out.println();
			System.out.println("Process		Completion Time		Waiting Time	Turnaround Time" );
			for(i=0 ; i<noOfProcess ; i++)
			{
				j = i + 1;
				
				System.out.println(j + "		" + completionTime1.get(i) + "			" + waitingTime1.get(i) + "		" + turnaroundTime1.get(i));
			}
			System.out.println();
			averageWaitingTimeMethod(process);
			
		}
		
		sc.close();
	}

}
