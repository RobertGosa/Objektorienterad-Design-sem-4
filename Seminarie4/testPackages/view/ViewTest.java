/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import controller.CouldNotAddItemException;
import integration.AccountingSystem;
import integration.DatabaseErrorException;
import integration.InventorySystem;
import integration.ItemNotFoundException;
import integration.SystemCreator;
import model.CashRegister;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Gosa
 */
public class ViewTest {
    SystemCreator creator = new SystemCreator();
    InventorySystem inventorySystem = creator.getInventorySystem();
    AccountingSystem accountingSystem = creator.getAccountingSystem();
    CashRegister cashRegister = new CashRegister();
    Controller contr = new Controller(inventorySystem, accountingSystem, cashRegister);

    /**
     * Test of addItem method, of class View.
     * @throws DatabaseErrorException 
     * @throws CouldNotAddItemException 
     */
    @Test
    public void testAddItem() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {
        try {
            contr.addItem(3, 0);
        } catch (ItemNotFoundException exc) {
            assertTrue("Wrong expected message", 
                    exc.getMessage().contains("Item with ID: " + 3 + " not found."));
        }
        
    }
   
}