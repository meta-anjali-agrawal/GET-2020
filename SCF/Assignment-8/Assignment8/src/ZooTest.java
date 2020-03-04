import static org.junit.Assert.*;
import org.junit.Test;

public class ZooTest 
{
	Zoo object=new Zoo();
	@Test
	public void addZoneTest()
	{
		assertEquals(true,object.addZone("Lion", 3, true, true));
	}
	@Test
	public void addCageTest()
	{
		assertEquals(true,new Zone("Lion", 3, true, true).addCage("Lion", 2));
	}
	/*@Test
	public void addAnimalTest()
	{
		assertEquals(true,object.addAnimal("Lion","ABC",45,78, "Lion"));
	}*/
	/*@Test
	public void deathAnimalTest()
	{
		assertEquals(false,object.deathAnimal("Lion",101));
	}*/

}
