package com.metacube.repository;

import java.util.*;

import com.metacube.pojo.Inventory;

public class InventoryRepository {

	List<Inventory> inventories;
	
	public InventoryRepository()
	{		
		
		inventories=new ArrayList<>();
		Inventory a1=new Inventory();
		a1.setName("chickoo");
		a1.setQuantity(3);
		
		Inventory a2=new Inventory();
		a2.setName("Oranges");
		a2.setQuantity(7);
		
		Inventory a3=new Inventory();
		a3.setName("Pear");
		a3.setQuantity(55);
		
		Inventory a4=new Inventory();
		a4.setName("asdf");
		a4.setQuantity(90);
		
		inventories.add(a1);
		inventories.add(a2);
		inventories.add(a3);
		inventories.add(a4);
		System.out.println("hello");
		
	}
	
	public List<Inventory> getInventories()
	{
		return inventories;
	}
	
	public Inventory getInventory(String name)
	{
		for(Inventory a:inventories)
		{
			if(a.getName().compareTo(name)==0)
				return a;
		}
		return new Inventory();
	}
	
	public void create(Inventory a1)
	{
		inventories.add(a1);
	}
	
	public void update(Inventory a1)
	{
		inventories.removeAll(inventories);
		inventories.add(a1);		
	}
	
	public Inventory updateOne(String name,Inventory a2)
	{
		for(Inventory a:inventories)
		{
			if(a.getName().compareTo(name)==0)
			{
				a.setName(a2.getName());
				a.setQuantity(a2.getQuantity());
				return a;
			}
				
		}
		return new Inventory();		
	}
	
	public void deleteOne(String name)
	{
		inventories.remove(getInventory(name));
	}

	public void deleteAll() 
	{
		inventories.removeAll(inventories);		
	}

	
}
