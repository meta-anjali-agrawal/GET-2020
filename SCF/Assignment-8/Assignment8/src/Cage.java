import java.util.*;

public class Cage 
{
	List<Animal> animalList = new ArrayList<Animal>();
	String animalType;
	int capacity;
	int noOfAnimal = 0;
	static int counter=0;
	int cageID = 0;

	Cage(String animalType, int capacity)
	{
		this.animalType = animalType;
		this.capacity = capacity;
		counter++;
		this.cageID=counter;
	}
	
	boolean isCageFull()
	{
		if(capacity==noOfAnimal)
		{
			return true;
		}
		return false;
	}
	
	public Boolean addAnimalToCage(String name, int age, double weight,String type)
	{
		if(!isCageFull())
		{
			if(type.equalsIgnoreCase("Lion"))
			{
				Lion lion = new Lion(name, age, weight);
				animalList.add(lion);
				return true;
			}
			else if(type.equalsIgnoreCase("Crocodile"))
			{
				Crocodile crocodile = new Crocodile(name, age, weight);
				animalList.add(crocodile);
				return true;
			}
			else if(type.equalsIgnoreCase("Peacock"))
			{
				Peacock peacock = new Peacock(name, age, weight);
				animalList.add(peacock);
				return true;
			}
			else
			{
				System.out.println("Enter a valid Animal.");
				return false;
			}
		}
		else
		{
			System.out.println("Can not be added, out of capacity");
			return false;
		}
	}
	
	public boolean removeAnimalFromCage(int Id)
	{
		for(int i=0 ; i<animalList.size() ; i++)
		{
			if(animalList.get(i).Id==Id)
			{
				animalList.remove(animalList.get(i));
				return true;
			}
		}
		return false;
	}
	
	public void displayAnimalList()
	{
		System.out.println("AnimalId\tAnimalName\tAnimalWight\tAnimalAge");
		for(int i=0 ; i<animalList.size() ; i++)
		{
			System.out.println(animalList.get(i).Id + "\t\t"+animalList.get(i).name + "\t\t"+animalList.get(i).weight + "\t\t" + animalList.get(i).age);
		}
	}
	

	/*public int getCageID() 
	{
		return CageID;
	}*/
}
