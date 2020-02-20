import java.util.*;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Zoo zoo = new Zoo();
		int option;
		
		do
		{
			System.out.println("Select:");
			System.out.println("1.Add Zone \n2.Delete Zone");
		    System.out.println("3.Add cage \n4.Delete Cage");
		    System.out.println("5.Add Animal \n6.Delete Animal");
		    System.out.println("7.Display \n8.Exit");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					System.out.println("List of animals: \n1. Lion \n2.Crocodile \n3.Peacock");
					System.out.println("Animal Category");
					String animalCategory = sc.next();
					System.out.println("Capacity of cages");
					int limitNoOfCages = sc.nextInt();
					System.out.println(" canteen");
					boolean hasCanteen = sc.nextBoolean();
					System.out.println("Park");
					boolean hasPark = sc.nextBoolean();
					zoo.addZone(animalCategory, limitNoOfCages, hasCanteen, hasPark);
					break;
				case 2:
					for(Zone zone : zoo.zoneList)
					{
						System.out.println(zone.zoneID + "  "  + zone.animalCategory);
					}
					System.out.println("Enter Zone Id you want to delete");
					int zoneId = sc.nextInt();
					zoo.deleteZone(zoneId);
					break;
				case 3:
					//display list of zones and add cage to that specific zone
					for(Zone zone : zoo.zoneList)
					{
						System.out.println(zone.zoneID + "  "  + zone.animalCategory);
					}
					System.out.println("Enter the animal category");
					String animalType = sc.next();
					System.out.println("Enter the capacity");
					int capacity = sc.nextInt();
					for(Zone zone : zoo.zoneList)
					{
						if(zone.animalCategory.equalsIgnoreCase(animalType))
							zone.addCage(animalType, capacity);
						else
							System.out.println("Error!!!!!!");
					}
					break;
				case 4:
					for(Zone zone : zoo.zoneList)
					{
						for(Cage cage : zone.cageList)
						{
							if(zone.animalCategory.equalsIgnoreCase(cage.animalType))
								System.out.println(cage.cageID + "  " + cage.animalType + "  " + cage.capacity);
						}
					}
					System.out.println("Enter the animal category");
					String animalType1 = sc.next();
					System.out.println("Enter the Cage Id");
					int cageId = sc.nextInt();
					for(Zone zone : zoo.zoneList)
					{
						if(zone.animalCategory.equalsIgnoreCase(animalType1))
							zone.removeCage(cageId);
					}
					break;
				case 5:
					System.out.println("Enter animal type: ");
					String category1 = sc.next();
					System.out.println("Enter name:");
					String animalName = sc.next();
					System.out.println("Enter weight:");
					int animalWeight = sc.nextInt();
					System.out.println("Enter age:");
					int animalAge = sc.nextInt();
					if (zoo.addAnimal(category1, animalName, animalWeight, animalAge, category1)) 
					{
						System.out.println("successfully added");
					} 
					else 
					{
						System.out.println("operation failed");
					}
					break;
				case 6:
					for(Zone zones : zoo.zoneList)
					{
						for(Cage cage : zones.cageList)
						{
							for(Animal animal : cage.animalList)
							{
								if(zones.animalCategory.equalsIgnoreCase(animal.getAnimal()))
									System.out.println(animal.Id + "  " + animal.getAnimal() + "  " + animal.name + "  " + animal.getSound());
								
							}
						}
						System.out.println();
					}
					System.out.println("Enter animal type:");
					String category2 = sc.next();
					System.out.println("Enter Id");
					int animalId1 = sc.nextInt();
					if (zoo.deathAnimal(category2, animalId1))
					{
						System.out.println("successfully deleted");
						break;
					} 
					else
					{
						System.out.println("operation failed");
						break;
					}
				case 7:
					System.out.println("Zone:");
					for(Zone zones : zoo.zoneList)
					{
						System.out.println(zones.zoneID + "  "  + zones.animalCategory + "  " + zones.limitNoOfCages);
						System.out.println();
						System.out.println("Cage:");
						for(Cage cage : zones.cageList)
						{
							if(zones.animalCategory.equalsIgnoreCase(cage.animalType))
								System.out.println(cage.cageID + "  " + cage.animalType + "  " + cage.capacity);
							System.out.println("Animal:");
							for(Animal animal : cage.animalList)
							{
								if(zones.animalCategory.equalsIgnoreCase(animal.getAnimal()))
									System.out.println(animal.Id + "  " + animal.getAnimal() + "  " + animal.name + "  " + animal.getSound());
								
							}
						}
						System.out.println();
					}
					break;
				case 8:
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid choice");
					break;
			}
		}while(option != 8);
		
		sc.close();
	}

}