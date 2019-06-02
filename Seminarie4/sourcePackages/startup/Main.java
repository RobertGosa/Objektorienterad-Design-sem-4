package startup;

import java.io.IOException;

import controller.CouldNotAddItemException;
import controller.Controller;
import integration.Printer;
import integration.SystemCreator;
import model.CashRegister;
import model.Receipt;
import integration.InventorySystem;
import integration.ItemNotFoundException;
import integration.AccountingSystem;
import view.View;

public class Main {
	public static void main(String[] args) throws ItemNotFoundException, CouldNotAddItemException, IOException {
		SystemCreator creator = new SystemCreator();
		InventorySystem InventorySystem = creator.getInventorySystem();
		AccountingSystem AccountingSystem = creator.getAccountingSystem();
		CashRegister CashRegister = new CashRegister();
        Controller contr = new Controller(InventorySystem, AccountingSystem, CashRegister);
        View view = new View(contr);
        Printer printer = new Printer();
        view.runSale();
        view.addItem(0, 2);
        view.addItem(0, 2);
        view.addItem(1, 3);
        view.addItem(2, 4);
        view.addItem(3, 4);
        view.addItem(4, 4);
        view.addItem(0, 1);
        view.signalDiscountRequest(20381739);
        view.pay(110);
        Receipt receipt = view.requestReceipt();
        printer.printReciept(receipt);
        
        view.runSale();
        view.addItem(0, 1);
        view.addItem(0, 1);
        view.signalDiscountRequest(20381739);
        view.pay(200);
        Receipt receipt2 = view.requestReceipt();
        printer.printReciept(receipt2);
    }
}