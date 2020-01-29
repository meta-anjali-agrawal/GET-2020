
public class Crocodile extends Reptile  
{

	public Crocodile(String name, int age, double weight)
	{
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAnimal()
	{
		return "Crocodile";
	}
	
	@Override
	String getSound() 
	{
		// TODO Auto-generated method stub
		return "Bellow";
	}

}
