import java.util.*;

public class Zone 
{
	List<Cage> cageList = new ArrayList<Cage>();//take id
	static int counter=0;
	String animalCategory;
	int limitNoOfCages;
	int noOfZones = 0;
	boolean hasPark;
	boolean hasCanteen;
	int zoneID=0;
	
	Zone(String animalCategory, int limitNoOfCages, boolean hasCanteen, boolean hasPark)
	{
		this.animalCategory = animalCategory;
		this.limitNoOfCages = limitNoOfCages;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		noOfZones++;
		counter++;
		this.zoneID=counter;
	}
	
	public boolean addCage(String animalType, int capacity)
	{
		Cage cage = new Cage(animalType, capacity);
		cageList.add(cage);
		return true;
	}
	
	public boolean removeCage(int cageId)
	{
		for(int i=0 ; i<cageList.size() ; i++)
		{
			if(cageList.get(i).cageID==cageId)
			{
				cageList.remove(cageList.get(i));
				return true;
			}
		}
		return false;
	}
	
	public Cage checkCage(String cageType)
	{
		for(int i=0 ; i<cageList.size() ; i++)
		{
			if(cageList.get(i).animalType.equalsIgnoreCase(cageType))
			{
				return cageList.get(i);
			}
		}
		return null;
	}
	
	public void displayCageList()
	{
			System.out.println("CageId\t\tCageType\tCageTotalCapacity");
			for(int i=0 ; i<cageList.size() ; i++)
			{
				System.out.println(cageList.get(i).cageID + "\t\t" + cageList.get(i).animalType + "\t\t" + cageList.get(i).capacity);
			}
	}
}
