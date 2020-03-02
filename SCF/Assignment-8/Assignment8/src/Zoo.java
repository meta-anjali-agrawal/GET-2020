import java.util.*;

public class Zoo
{
	List<Zone> zoneList = new ArrayList<Zone>();
	Scanner sc = new Scanner(System.in);
	
	public boolean addZone(String animalCategory, int limitNoOfCages, boolean hasCanteen, boolean hasPark)
	{
		Zone zone = new Zone(animalCategory, limitNoOfCages, hasCanteen, hasPark);
		zoneList.add(zone);
		return true;
	}
	
	public boolean deleteZone(int zoneId)
	{
		for(int i=0 ; i<zoneList.size() ; i++)
		{
			if(zoneList.get(i).zoneID==zoneId)
			{
				zoneList.remove(zoneList.get(i));
				return true;
			}
		}
		return false;
	}
	
	public Zone checkZone(String category)
	{
		for(int i=0 ; i<zoneList.size() ; i++)
		{
			if(zoneList.get(i).animalCategory.equalsIgnoreCase(category))
			{
				return zoneList.get(i);
			}
		}
		return null;
	}
	
	public boolean addAnimal(String category,String name,int weight,int age, String type)
	{
		String animalCategory= category;
		String animalName=name;
		int animalWeight= weight;
		int animalAge= age;
		String animalType = type;
		if(checkZone(animalCategory)!=null)
		{
			if(checkZone(animalCategory).checkCage(type)!=null)
			{
				/*Animal animal = null;
				if(type.equalsIgnoreCase("Lion"))
				{
					animal = new Lion(animalName,animalWeight,animalAge);
				}
				if(type.equalsIgnoreCase("Crocodile"))
				{
					animal = new Crocodile(animalName,animalWeight,animalAge);
				}
				if(type.equalsIgnoreCase("Peacock"))
				{
					 animal = new Peacock(animalName,animalWeight,animalAge);
				}*/
				return (checkZone(animalCategory).checkCage(type).addAnimalToCage(animalName,animalWeight,animalAge, animalType));
			}
			else
			{
				System.out.println("cage not found");
				System.out.println("create new Cage?\n1.Yes\n2.No");
				
				while(true)
				{
					int choice = sc.nextInt();
					switch(choice)
					{
						case 1: 
							int capacity = sc.nextInt();
							checkZone(animalCategory).addCage(animalType, capacity);
							return addAnimal(animalCategory, animalName, animalWeight, animalAge, animalType);
						case 2:
							System.out.println("Thank you");
							return false;
						default: 
							System.out.println("Please enter valid choice");
							break;
					}
				}
			}
		}
		else
		{
			System.out.println("Zone not found");
			System.out.println("create new Zone?\n1.Yes\n2.No");
			
			while(true)
			{
				int choice = sc.nextInt();
				switch(choice)
				{
					case 1: 
						System.out.println("Capacity of cages");
						int limitNoOfCages = sc.nextInt();
						System.out.println("Canteen");
						boolean hasCanteen = sc.nextBoolean();
						System.out.println("Park");
						boolean hasPark = sc.nextBoolean();
						addZone(animalCategory, limitNoOfCages, hasCanteen, hasPark);
						return addAnimal(animalCategory, animalName, animalWeight, animalAge, animalType);
					case 2: 
						System.out.println("Thank you");
						return false;
					default:System.out.println("Please enter valid choice");
							break;
				
				}
			}
		}	
	}
	
	public boolean deathAnimal(String category1, int id)
	{
		String category= category1;
		int animalId=id;
		if(checkZone(category)!=null)
		{
			if(checkZone(category).checkCage(category)!=null)
			{
				checkZone(category).checkCage(category).removeAnimalFromCage(animalId);
				return true;
			}
			else
			{
				System.out.println("cage not found");
				return false;
			}
		}
		else
		{
			System.out.println("Zone not found");
			return false;
		}
		
	}
	
	public void displayZoneList()
	{
		System.out.println("Zone Id \t\t Zone capacity \t Zone Category");
		for(int i=0;i<zoneList.size();i++)
		{
			System.out.println(zoneList.get(i).zoneID + "\t\t" + zoneList.get(i).limitNoOfCages + "\t\t" + zoneList.get(i).animalCategory);
		}
	}
	
}
