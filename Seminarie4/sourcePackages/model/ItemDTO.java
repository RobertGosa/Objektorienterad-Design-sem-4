package model;

public class ItemDTO {
	private double price;
	private int itemIdentifier;
	private String itemDescription;
	private double vAT;
	private int quantity;

	public ItemDTO (double price, int itemIdentifier, String itemDescription, double VAT, int quantity){
		this.price = price;
		this.itemIdentifier = itemIdentifier;
		this.itemDescription = itemDescription;
		this.vAT = VAT;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getItemIdentifier() {
		return this.itemIdentifier;
	}
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	public double getVAT() {
		return this.vAT;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}

}
