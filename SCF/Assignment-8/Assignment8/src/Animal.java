
abstract class Animal 
{
	String name;
	int Id = 0;
	int age;
	double weight;
	
	Animal(String name, int age, double weight)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		Id++;
	}
	
	abstract String getSound();
	abstract String getAnimal();
}
