
public class Bird extends Animal
{

	public Bird(String name, int age, double weight) 
	{
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}

	public String getCategory()
	{
		return "Bird";
	}
	
	@Override
	String getSound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

}
