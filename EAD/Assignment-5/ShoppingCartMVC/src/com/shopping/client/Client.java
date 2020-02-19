package com.shopping.client;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.shopping.controller.CartController;
import com.shopping.message.CartMessage;
import com.shopping.model.Item;
/**
 * @author Anjali
 * Client class which act as a view for MVC pattern of shopping cart
 */
public class Client 
{
	
	static Scanner scanner = new Scanner(System.in);
	static int itemId = 0, itemQuantity = 0, option, amount, flag = 0;
	final static int addItem = 1, viewCart = 2, editCart = 3, removeItem = 4, bill = 5, exit = 6;
	
	/**
	 * Method for user functionality  
	 */
	public static void userInput()
	{
		do
		{
			System.out.println(CartMessage.optionHeader);
			System.out.println(CartMessage.selectOption);
			try 
			{
				option = scanner.nextInt();
				switch(option)
				{
				
				case addItem:
					do{
						try{
							System.out.println(CartMessage.enterId);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size())
							{
								System.out.println(CartMessage.invalidId);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e)
						{
							System.out.print(CartMessage.invalidId);
							System.out.println("");
						}
						scanner.nextLine();
					}while(flag == 0);
					do
					{
						try
						{
							System.out.println(CartMessage.enterQuantity);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0)
							{
								System.out.println(CartMessage.quantityInvalid);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) 
						{
							System.out.print(CartMessage.quantityInvalid);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.addItemController(itemId, itemQuantity);
					break;
					
				case viewCart:
					CartController.viewCartController();
					break;
					
				case editCart:
					do
					{
						try
						{
							System.out.println(CartMessage.enterIdEdit);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size())
							{
								System.out.println(CartMessage.invalidId);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) 
						{
							System.out.print(CartMessage.invalidId);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					do
					{
						try
						{
							System.out.println(CartMessage.enterQuantity);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0)
							{
								System.out.println(CartMessage.quantityInvalid);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) 
						{
							System.out.print(CartMessage.quantityInvalid);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.editItemController(itemId,itemQuantity);
					break;
					
				case removeItem:
					do
					{
						try
						{
							System.out.println(CartMessage.enterIdRemove);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size())
							{
								System.out.println(CartMessage.invalidId);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e)
						{
							System.out.print(CartMessage.invalidId);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					CartController.removeItemController(itemId);
					break;
					
				case bill:
					amount = CartController.billController();
					if(amount == 0)
						System.out.println(CartMessage.emptyCart);
					else
						System.out.println("The total amount is :" + amount);
					break;
					
				case exit:
					System.out.println(CartMessage.thankYou);
					System.exit(0);
					break;
					
				default:
					System.out.println(CartMessage.invalidOption);
				}
			} 
			catch (Exception e) 
			{
				System.out.println(CartMessage.invalidOption);
				scanner.nextLine();
			}
		}while(true);	
	}
	
	/**
	 * Main method for executing the shopping cart
	 */
	public static void main(String args[])
	{
		HashMap<Integer, Item> products = CartController.allAvailableItemsController();
		CartController.showItem(products);
		userInput();
	}
}
