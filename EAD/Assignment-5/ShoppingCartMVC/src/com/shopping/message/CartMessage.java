package com.shopping.message;

/**
 * 
 * @author Anjali
 * Contains messages requires in shopping cart
*/
public class CartMessage 
{
	public final static String quantityGreaterAlert = "Quantity must be less than or equal to 50, 50 quantity added";
	public final static String alreadyAdded = "The item is already in the cart, quantity updated to:";
	public final static String emptyCart = "Cart is Empty";
	public final static String itemAdded = "Your product is added successfully.";
	public final static String invalidId = "Id is invalid !! Please enter a valid Id";
	public final static String itemNotInCart = "Sorry!! The entered item is not in your cart";
	public final static String quantityInvalid = "Quantity is invalid !! Please enter a valid quantity";
	public final static String invalidOption = "Enter correct choice";
	public final static String shoppingHeader = "Id" +" \t \t"+ "Item Name" +" \t"+ "Price";
	public final static String selectOption = "Select your option:";
	public final static String enterId = "Enter Item Id to add in your cart";
	public final static String optionHeader = "Options :"+"\n"+"1: Add item"+"\n"+"2: View cart"+"\n"+"3: Edit cart"+"\n"+"4: Remove item from cart"+"\n"+"5: Generate Bill"+"\n"+"6: Exit";
	public final static String enterQuantity = "Enter Quantity: ";
	public final static String enterIdEdit = "Enter Item Id to be edit";
	public final static String enterIdRemove = "Enter Item Id to be remove from cart";
	public final static String cartHeader = "Id" +" \t \t"+ "Item Name" +" \t"+ "Quantity";
	public final static String itemEdited = "Item edited successfully";
	public final static String thankYou = "Thank You!!";
	public final static String itemRemoved = "Item removed successfully";
}
