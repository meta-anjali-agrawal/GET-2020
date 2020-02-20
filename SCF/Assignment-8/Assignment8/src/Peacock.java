
public class Peacock extends Bird 
{

	public Peacock(String name, int age, double weight) 
	{
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAnimal()
	{
		return "Peacock";
	}
	
	@Override
	String getSound() 
	{
		// TODO Auto-generated method stub
		return "Scream";
	}

}
