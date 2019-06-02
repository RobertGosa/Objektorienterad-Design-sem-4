package model;

public class CashRegister {
	private double balance = 0.0;
	
	public void addPayment(double payment) {
		balance += payment;
	}
	
	public double calculateChange(double payment, double cost){
		return payment - cost;
	}
	
	public double getBalance() {
		return balance;
	}
}
