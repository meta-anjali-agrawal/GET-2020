package com.shopping.facade;

import java.util.HashMap;

import com.shopping.dao.CartDao;
import com.shopping.message.CartMessage;
import com.shopping.model.Item;
/**
 * @author Anjali
 * Facade class for adding operations for different layers
*/
public class CartFacade 
{
	/**
	 * Facade method for getting all the items in shopping site
	 * @return : map of products
	*/
	public static HashMap<Integer, Item> allAvailableItemsFacade()
	{
		HashMap<Integer, Item> products = CartDao.allAvailableItems();
		return products;
	}
	
	/**
	 * Facade method for adding items in user cart.
	 * @param id : Id of product
	 * @param quantity : quantity of items
	*/
	public static void addItemFacade(int id,int quantity)
	{
		CartDao.addItem(id, quantity);
	}
	
	/**
	 * Facade method for viewing the user cart
	*/
	public static void viewCartFacade()
	{
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		if(userCart.isEmpty())
		{
			System.out.println(CartMessage.emptyCart);
		}
		else
		{
			System.out.println(CartMessage.cartHeader);
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			{
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity());			
			}
		}
	}
	
	/**
	 * 
	 * @param id : Id of product
	 * @param quantity : quantity of product
	 * Facade method for editing the quantity of item to cart
	*/
	public static void editItemFacade(int id,int quantity)
	{
		CartDao.editItem(id, quantity);
	}
	
	/**
	 * 
	 * @param id : Id of product
	 * Facade method for removing item from user cart
	*/
	public static void removeItemFacade(int id)
	{
		CartDao.removeItem(id);
	}
	
	/**
	 * Facade method for generating bill of user cart
	 * @return : bill amount
	*/
	public static int billFacade()
	{
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity() * entry.getValue().getPrice();
		return amount;
	}
}
