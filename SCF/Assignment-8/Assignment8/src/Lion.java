
public class Lion extends Mammal 
{

	public Lion(String name, int age, double weight)
	{
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAnimal()
	{
		return "Lion";
	}

	@Override
	String getSound() 
	{
		// TODO Auto-generated method stub
		return "Roar";
	}
}
