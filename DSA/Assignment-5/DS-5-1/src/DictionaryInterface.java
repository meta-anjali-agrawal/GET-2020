import java.util.List;


public interface DictionaryInterface 
{
	
	public void add(String key, String value);
	public Node delete(String key);
	public String getValue(String key);
	public List<Node> sort();
	public List<Node> sortSublist(String K1, String K2);
	
}
