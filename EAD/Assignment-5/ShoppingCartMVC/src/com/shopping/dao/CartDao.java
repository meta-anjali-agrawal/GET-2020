package com.shopping.dao;

import java.util.HashMap;

import com.shopping.message.CartMessage;
import com.shopping.model.Item;
/**
 * @author Anjali
 * Dao class for data related functionality of shopping cart
*/
public class CartDao 
{
	/**
	 * Map for product id and products object which contain detail about product
	*/
	static HashMap<Integer, Item> products = new HashMap<Integer,Item>();	
	/**
	 * Map for product id and products object which are in the cart of user
	*/
	static HashMap<Integer,Item> userCart =new HashMap<Integer,Item>(); 
	
	/**
	 * Method for creating items in the shopping site
	*/
	public static HashMap<Integer, Item> allAvailableItems()
	{
		Item prod1 = new Item("Candy",40);
		Item prod2 = new Item("Bread",30);
		Item prod3 = new Item("Butter",50);
		Item prod4 = new Item("Milk",43);
		Item prod5 = new Item("Toast",60);
		Item prod6 = new Item("Curd",20);
		Item prod7 = new Item("Cream",80);
		Item prod8 = new Item("Pastry",45);
		Item prod9 = new Item("Cake",300);
		Item prod10 = new Item("Panner",200);
		Item prod11 = new Item("Egg",8);
		products.put(1,prod1);
		products.put(2,prod2);
		products.put(3,prod3);
		products.put(4,prod4);
		products.put(5,prod5);
		products.put(6,prod6);
		products.put(7,prod7);
		products.put(8,prod8);
		products.put(9,prod9);
		products.put(10,prod10);
		products.put(11,prod11);
		return products;
	}
	
	/**
	 * Method for adding items in user cart.
	 * @param id : Id of product
	 * @param quantity : quantity of items
	*/
	public static void addItem(int id,int quantity)
	{
		if(userCart.containsKey(id))
		{
			int newQuantity = userCart.get(id).getQuantity() + quantity;
			System.out.println("hello"+userCart.get(id).getQuantity());
			userCart.get(id).setQuantity(newQuantity);
			System.out.println(CartMessage.alreadyAdded + newQuantity);
		}
		else
		{
			products.get(id).setQuantity(quantity);
			userCart.put(id,products.get(id));
			System.out.println(CartMessage.itemAdded);
		}
	}
	
	/**
	 * 
	 * @param id : Id of product
	 * @param quantity : quantity of product
	 * Method for editing the quantity of item to cart
	*/
	public static void editItem(int id,int quantity)
	{
		if(!userCart.containsKey(id))
		{
			System.out.println(CartMessage.itemNotInCart);
		}
		else
		{
			System.out.println(CartMessage.itemEdited);
			userCart.get(id).setQuantity(quantity);
		}
	}
	
	/**
	 * 
	 * @param id : Id of product
	 * Method for removing item from user cart
	*/
	public static void removeItem(int id)
	{
		if(!userCart.containsKey(id))
		{
			System.out.println(CartMessage.invalidId);
		}
		else
		{
			userCart.remove(id);
			System.out.println(CartMessage.itemRemoved);
		}
	}
	
	/**
	 * Method for getting the user cart 
	 * @return : map of user cart
	*/
	public static HashMap<Integer,Item> getUserCart()
	{
		return userCart;
	}
}
