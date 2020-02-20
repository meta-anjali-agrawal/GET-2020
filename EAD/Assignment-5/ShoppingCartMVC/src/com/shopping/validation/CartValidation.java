package com.shopping.validation;

import com.shopping.message.CartMessage;
/**
 * @author Anjali
 * Cart validation class 
*/
public class CartValidation 
{
	/**
	 * Method for validating the quantity of item
	 * @param quantity : quantity of item
	 * @return : quantity 
	*/
	public static int quantityValidation(int quantity)
	{
		if(quantity > 50)
		{
			quantity = 50;
			System.out.println(CartMessage.quantityGreaterAlert);
		}
		return quantity;
	}
}
