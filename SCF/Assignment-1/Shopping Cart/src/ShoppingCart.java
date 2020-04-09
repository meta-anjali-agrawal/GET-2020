import java.util.*;

class Item
{
	HashMap<String, Double> items = new HashMap<String, Double>();
	Item()
	{
		items.put("BREAD", 20.00);
		items.put("BUTTER", 46.00);
		items.put("MILK", 22.00);
		items.put("EGG", 7.50);
	}
	public void show()
	{
		System.out.println("******List of Items in Basket******");
		System.out.println("	" + "Item Name" + "	" + "Price");
		for(String name : items.keySet())
		{
			Double price = items.get(name);
			System.out.println("	" + name + "		" + price);
		}
	}
}

class Cart
{
	HashMap<String,Integer> cartItem = new HashMap<>();
	Item i1 = new Item();
	
	
	public void addToCart(String itemName, int quantity)
	{
		if(i1.items.containsKey(itemName))
		{
			if(quantity > 0)
				cartItem.put(itemName, quantity);
		}
		else
			System.out.println("SORRY!! Select item from the given list above.");
	}
	
	public void removeFromCart(String itemName)
	{
		if(cartItem.containsKey(itemName))
		{
			cartItem.remove(itemName);
		}
		else
			System.out.println("SORRY!! Select an item from the cart.");
	}
	
	public void updateQuantity(String itemName, int quantity)
	{
		if(cartItem.containsKey(itemName))
		{
			if(quantity == 0)
			{
				cartItem.remove(itemName);
			}
			else if(quantity<0)
			{
				System.out.println("Oops!!! Enter a valid number.");
			}
			else
			{
				cartItem.put(itemName, quantity);
			}
		}
		else
			System.out.println("SORRY!! Select an item from the cart.");
	}
	
	public void displayCart()
	{
		System.out.println("Items in Cart are:");
		for(String name : cartItem.keySet())
		{
			int quant = cartItem.get(name);
			System.out.println("Item - " + name + "	Quantity - " + quant);
		}
	}
	
	public void generateBill()
	{
		Double totalPrice =0.00, itemPrice;
		System.out.println("Items	Quantity	Price");
		for(String name : cartItem.keySet())
		{
			int quant = cartItem.get(name);
			Double price = i1.items.get(name);
			itemPrice = quant*price;
			totalPrice = totalPrice + itemPrice;
			System.out.println(name + "		" + quant + "		" + itemPrice);
		}
		System.out.println("Total Price : " + totalPrice);
	}
}

public class ShoppingCart 
{
	
	
	public static void main(String[] args) 
	{
		Item i = new Item();
		Cart c = new Cart();
		Scanner sc = new Scanner(System.in);
		int quantity, option;
		String itemName;
		
		try
		{
			do
			{
				System.out.println("Choose the option among the following:");
				System.out.println("1. Add an item to Cart.");
				System.out.println("2. Remove an item from the Cart");
				System.out.println("3. Update Cart");
				System.out.println("4. Display Cart");
				System.out.println("5. Generate Bill");
				System.out.println("6. Exit");
				
				option = sc.nextInt();
				switch(option)
				{
					case 1 :
						i.show();
						System.out.println("Enter the item name you want to add in cart:");
						itemName = sc.next().toUpperCase();
						System.out.println("Enter the quantity of item you want to add in cart:");
						quantity = sc.nextInt();
						c.addToCart(itemName, quantity);
						break;
					case 2 :
						c.displayCart();
						System.out.println("Enter the item name you want to remove from cart:");
						String iName = sc.next().toUpperCase();
						c.removeFromCart(iName);
						break;
					case 3:
						System.out.println("Enter the item name you want to update in cart:");
						itemName = sc.next().toUpperCase();
						System.out.println("Enter the quantity of item you want to update in cart:");
						quantity = sc.nextInt();
						c.updateQuantity(itemName, quantity);
						break;
					case 4:
						c.displayCart();
						break;
					case 5 :
						c.generateBill();
						System.exit(0);
						break;
					case 6 :
						System.exit(0);
					default :
						System.out.println("Select a valid Option.");
						break;
				}

			}while(option!=6);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		
		System.out.println("Thanks for Shopping with us!");
		sc.close();

	}

}
