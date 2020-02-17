package com.shopping.controller;

import java.util.HashMap;

import com.shopping.facade.CartFacade;
import com.shopping.message.CartMessage;
import com.shopping.model.Item;
/**
 * @author Anjali
 * Controller class for cart
*/
public class CartController 
{
	/**
	 * Controller method for getting all available items in shopping site
	 * @return : map of products
	*/
	public static HashMap<Integer, Item> allAvailableItemsController()
	{
		HashMap<Integer, Item> products = CartFacade.allAvailableItemsFacade();
		return products;
	}
	
	/**
	 * Controller method for showing the items added in user cart
	*/
	public static void showItem(HashMap<Integer, Item> products)
	{
		System.out.println(CartMessage.shoppingHeader);
		for (HashMap.Entry<Integer,Item> entry : products.entrySet())
		{
			System.out.println(entry.getKey() +" \t \t"+entry.getValue().getName()+" \t \t"+ entry.getValue().getPrice());
		}
	}
	
	/**
	 * Controller method for adding items in user cart.
	 * @param id Id of product
	 * @param quantity : quantity of items
	*/
	public static void addItemController(int id,int quantity)
	{
		CartFacade.addItemFacade(id, quantity);
	}
	
	/**
	 * Controller method for viewing the user cart
	*/
	public static void viewCartController()
	{
		CartFacade.viewCartFacade();
	}
	
	/**
	 * @param id : Id of product
	 * @param quantity : quantity of product
	 * Controller method for editing the quantity of ietm to cart
	*/
	public static void editItemController(int id,int quantity)
	{
		CartFacade.editItemFacade(id, quantity);
	}
	
	/**
	 * 
	 * @param id : Id of product
	 * Controller method for removing item from user cart
	*/
	public static void removeItemController(int id)
	{
		CartFacade.removeItemFacade(id);
	}
	
	/**
	 * 
	 * @return : total amount of all the item
	 * Controller method for generating bill 
	*/
	public static int billController()
	{
		return CartFacade.billFacade();
	}
}
