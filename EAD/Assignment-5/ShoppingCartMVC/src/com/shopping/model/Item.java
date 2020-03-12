package com.shopping.model;

import com.shopping.validation.CartValidation;
/**
 * @author Anjali
 * Model class for item in cart
*/
public class Item 
{	
	private double price;
	private int quantity;
	private String name;
	
	public Item(String name,int price)
	{
		this.price = price;
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = CartValidation.quantityValidation(quantity);
	}
	
	public String getName() 
	{
		return name;
	}
}
