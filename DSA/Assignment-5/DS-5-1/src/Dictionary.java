import java.util.*;

/**
 * 
 * @author Anjali
 * This class implements Dictionary as Binary Search Tree
 */
public class Dictionary implements DictionaryInterface
{
	
	Node root ;
	List<Node> list = new ArrayList<Node>();
	
	/**
	 * 
	 */
	Dictionary() 
	{
		root=null;
		ReadJson.readJSON();
		Map<String, String> pairs = ReadJson.getDictionaryMap();
		Set<String> keys = pairs.keySet();
		for(String k:keys){
			add(k, pairs.get(k));
		}
	}
	
	/**
	 * To add a pair to dictionary
	 * @param key
	 * @param value
	 */
	@Override
	public void add(String key, String value)
	{
		root = addToDictionary(key, value, root);
	}
	
	/**
	 * To add a pair to dictionary 
	 * @param key
	 * @param value
	 * @param current
	 * @return Node
	 */
	private Node addToDictionary(String key, String value, Node current) 
	{
		if(current == null) 
		{
			current = new Node(key, value);
			return current;
		}
		else 
		{
			if(key.compareTo(current.key) < 0)
			{
				current.left = addToDictionary(key, value, current.left);
			}
			else 
			{
				current.right = addToDictionary(key, value, current.right);
			}

			return current;
		}
	}
	
	/**
	 * To delete node from dictionary
	 * @param key of node
	 * @return deleted node
	 */
	@Override
	public Node delete(String key)
	{
		return deletePair(key, root);
	}

	/**
	 * To delete node from dictionary
	 * @param key of node
	 * @param root represents current root node
	 * @return deleted node
	 */
	private Node deletePair(String key, Node root) 
	{
		if (root == null)
			return root;

		if (key.compareTo(root.key) < 0) 
		{
			root.left = deletePair(key, root.left);
		}
		else if (key.compareTo(root.key) > 0) 
		{
			root.right = deletePair(key, root.right);
		}
		else 
		{
			if (root.left == null) 
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}

			root.key = inOrderSuccessor(root.right);
			root.right = deletePair(root.key, root.right);
		}
		return root;
	}
	
	/**
	 * To find the inorder successor for deletion
	 * @param root of tree
	 * @return key value of successor
	 */
	private String inOrderSuccessor(Node root) 
	{
		String minimum = root.key;
		while (root.left != null) 
		{
			minimum = root.left.key;
			root = root.left;
		}
		return minimum;
	}

	@Override
	public String getValue(String key) 
	{
		Node node = searchPair(root, key);
		if(node != null) {
			return node.value;
		}
		return null;
	}
	
	/**
	 * To search given pair
	 * @param search is the node
	 * @param key to be searched
	 * @return resultant node
	 */
	private Node searchPair(Node searchNode ,String key)
	{
		if(searchNode == null) 
		{
			return null;
		}
		else if(searchNode.key.equals(key)) 
		{
			return searchNode;
		}
		else 
		{
			if(key.compareTo(searchNode.key) > 0) 
			{
				searchNode = searchNode.right;
			}
			else
			{
				searchNode = searchNode.left;
			}

			return searchPair(searchNode, key);
		}
	}

	@Override
	public List<Node> sort() 
	{
		traversal(root);
		return list;
	}
	
	/**
	 * To traverse the list in inorder.
	 * @param node is the starting node i.e root
	 */
	private void traversal(Node node) 
	{
		if(node == null) 
		{
			return;
		}
		else
		{
			traversal(node.left);
			list.add(node);
			traversal(node.right);
			return;
		}
	}

	@Override
	public List<Node> sortSublist(String K1, String K2) 
	{
		List<Node> sublist = new ArrayList<Node>();
		traversal(root);
		int i = 0;
		for(i = 0; i < list.size(); i++)
		{
			if(list.get(i).key.equals(K1))
			{
				sublist.add(list.get(i));
				break;
			}
		}
		i++;
		while(i < list.size() && K2.compareTo(list.get(i).key) >= 0  ) 
		{
			sublist.add(list.get(i));
			i++;
		}

		return sublist;
	}
	
	public static void main(String args[])
	{
		Dictionary dict = new Dictionary();
		System.out.println(dict.getValue("A"));
		dict.add("E", "Egg");
		ArrayList<Node> sublist = (ArrayList<Node>) dict.sortSublist("C","E");
		for(Node list : sublist) 
		{
			System.out.println(list.key);
		}
	}
	
}
