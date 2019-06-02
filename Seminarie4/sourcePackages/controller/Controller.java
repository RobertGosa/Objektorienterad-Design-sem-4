package controller;

import model.CashRegister;
import model.ItemDTO;
import model.Receipt;
import model.Sale;
import view.TotalRevenueView;
import integration.InventorySystem;
import integration.ItemNotFoundException;
import integration.AccountingSystem;
import integration.DatabaseErrorException;

public class Controller {
	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private CashRegister cashRegister;
	private double totalPrice;
	public TotalRevenueView TRV = new TotalRevenueView();

    public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem, CashRegister cashRegister) {
    	this.inventorySystem = inventorySystem;
    	this.accountingSystem = accountingSystem;
    	this.cashRegister = cashRegister;
	}

	public void startNewSale() {
        sale = new Sale();
        sale.turnOnCashRegister();
        sale.addSaleObserver(TRV);
    }
    
	public ItemDTO addItem(int itemIdentifier, int itemQuantity) throws 
    ItemNotFoundException, CouldNotAddItemException {
	try {
        ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
        if(foundItem != null) {
    	sale.addItem(foundItem, itemQuantity);
    	return foundItem;
        } else {
		return null;
        }
    } catch (DatabaseErrorException exc) {
        throw new CouldNotAddItemException("Could not add the item.(Database error)", exc);
    }
}
    
    public double pay (double amount) {
    	double change = sale.pay(amount, totalPrice);
    	return change;
    }
    
    public double indicateAllItemsRegistered() {
    	totalPrice = sale.getRunningTotal();
    	return sale.getRunningTotal();
    }
    
    public double signalDiscountRequest() {
    	totalPrice = sale.calcDiscountedPrice();
    	return totalPrice;
    }
    
    public Receipt requestReceipt() {
    	Receipt receipt = new Receipt(sale, sale.getExistingItems());
    	return receipt;
    }
}