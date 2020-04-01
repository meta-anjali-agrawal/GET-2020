
public class Mammal extends Animal
{

	Mammal(String name, int age, double weight) 
	{
		super(name, age, weight);
	}
	
	public String getCategory()
	{
		return "Mammal";
	}

	@Override
	String getSound() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

}
