package view;

import controller.CouldNotAddItemException;
import controller.Controller;
import integration.ItemNotFoundException;

import java.io.IOException;
import java.lang.Math;
import model.ItemDTO;
import model.Receipt;
import model.Sale;

public class View {
	private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }
    
    public void addItem(int itemId, int quantity) throws 
    ItemNotFoundException, CouldNotAddItemException, IOException{
	try {
        ItemDTO currentItem = controller.addItem(itemId, quantity);
        printItemOnScreen(currentItem, quantity);
        
    } catch (ItemNotFoundException exc) {
        System.out.println(exc.getMessage());
    }
    catch (CouldNotAddItemException exc) {
       System.out.println(exc.getMessage());
    }
}

    public void runSale() {
    	controller.startNewSale();
        System.out.println("New sale was started.");
    }
    
    public void pay(double amount) {
    	double amountPaid = amount;
    	double change = controller.pay(amount);
    	printChange(amountPaid, change);
    }
    
    public void signalDiscountRequest(int customerId) {
    	double newTotalPrice = controller.signalDiscountRequest();
    	printDiscountedPrice(newTotalPrice);
    }
    
    private void printItemOnScreen(ItemDTO IDTO, int quantity) {
    	double runningTotal = controller.indicateAllItemsRegistered();
    	System.out.println("Item: " + IDTO.getItemDescription() + " x" + quantity + " Price: " + IDTO.getPrice() * quantity + " Running Total: " + runningTotal);
    }
    
    private void printDiscountedPrice(double price) {
    	System.out.println("Discounted price: " + price);
    }
    
    private void printChange(double amountPaid, double change) {
    	System.out.println("Amount paid : " + amountPaid + " Change: " + Math.round(change * 100.0) / 100.0);
    }
    
    public Receipt requestReceipt() {
    	Receipt receipt = controller.requestReceipt();
    	return receipt;
    }
}