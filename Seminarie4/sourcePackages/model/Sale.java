package model;

import integration.Printer;
import java.util.ArrayList;
import java.util.List;

public class Sale {
	private int vAT;
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
	private ArrayList<Integer> itemQuantity = new ArrayList<Integer>();
	private double runningTotal = 0.0;
	private int itemsExisting = 0;
	private double change;
	private double payment;
	CashRegister cashRegister;
	boolean itemFlag = false;
	boolean discountFlag = false;
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
	public void addItem(ItemDTO item, int quantity) {	
		if(itemList.isEmpty()) {
	            itemList.add(item);
	            itemQuantity.add(quantity);
	            itemFlag = true;
		}	
		for(int i = 0; i < itemList.size(); i++) {
	            if(itemAlreadyScanned(item, i)) {
			int quantTemp = itemQuantity.get(i);
	                itemQuantity.set(i,quantTemp + quantity);
			itemFlag = true;
	            } 
		}		
		if(!itemFlag){ 
	            itemList.add(item);
	            itemQuantity.add(quantity);
		}
	        
		itemFlag = false;
		calculateRunningTotal(item, quantity);	
	    }
	
	public void turnOnCashRegister() {
		cashRegister = new CashRegister();
	}
	
	public double pay(double payment, double newTotalPrice) {
		change = cashRegister.calculateChange(payment, newTotalPrice);
		this.payment = payment;
		cashRegister.addPayment(payment - change);
		notifyObservers(calcDiscountedPrice());
		return change;
	}
	
	private boolean itemAlreadyScanned(ItemDTO item, int i) {
        if (item.getItemIdentifier() == itemList.get(i).getItemIdentifier() && itemFlag == false){
            return true;
        }   
        else
            return false;
    }
	
	private void calculateRunningTotal(ItemDTO foundItem, int itemQuantity) {
		this.runningTotal += foundItem.getPrice() * itemQuantity;
	}
	
	public double getRunningTotal() {
		if(!discountFlag) {
			return this.runningTotal;
		} else {
			return runningTotal * 0.8;
		}
	}
	
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}
	
	public int getExistingItems() {
		return itemsExisting + 1;
	}
	
	public double getChange() {
		return Math.round(change * 100.0) / 100.0;
	}
	
	public double getAmountPaid() {
		return payment;
	}
	
	public ArrayList<Integer> getItemQuantityList() {
        return this.itemQuantity;
    }
	
	public double calcDiscountedPrice() {
		discountFlag = true;
		return this.runningTotal * 0.8;
	}
	
	/**
     * Adds an observer to the list saleObservers
     * @param saleObs The observer to be added to the list.
     */
    public void addSaleObserver(SaleObserver saleObs) {
        saleObservers.add(saleObs);
    }
    
    /**
     * All the specified observers will be notified when a sale has been paid for.
     * @param observers The observers to notify.
     */
    public void addSaleObservers(List<SaleObserver> observers) {
        saleObservers.addAll(observers);
    }
    
    private void notifyObservers(double paidAmount) {
        for(SaleObserver obs: saleObservers) {
            obs.newPayment(paidAmount);
        }
    }
}