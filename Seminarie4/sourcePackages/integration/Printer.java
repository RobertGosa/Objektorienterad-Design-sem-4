package integration;

import java.util.ArrayList;

import model.ItemDTO;
import model.Receipt;

public class Printer {
	
	public void printReciept(Receipt receipt) {
		System.out.println("");
		System.out.println("Receipt:");
		System.out.println(receipt.getName());
		System.out.println(receipt.getAdress());
		System.out.println(receipt.getTime());
		ArrayList<ItemDTO> itemList = receipt.getItemList();
		for(int i = 0; i < receipt.getItems(); i++) {
			System.out.print(itemList.get(i).getItemDescription());
			System.out.print(" x" + itemList.get(i).getQuantity());
			System.out.print(" Price: " + itemList.get(i).getPrice() * itemList.get(i).getQuantity());
			System.out.println("");
		}
		System.out.println("Total: " + receipt.getTotal());
		System.out.println("Amount paid: " + receipt.getAmountPaid());
		System.out.print("Change: " + receipt.getChange());
	}
}