/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import integration.SystemCreator;
import java.util.ArrayList;
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
public class SaleTest {
    
    public SaleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItemFirstItem() {
        SystemCreator creator = new SystemCreator();
        
        int quantity = 5;
        ItemDTO item = new ItemDTO(0.0, 1, "aa", 0.0, 1);
        
        Sale instance = new Sale();
        
        instance.addItem(item, quantity);
        ArrayList<Integer> itemQuantity = instance.getItemQuantityList(); 
        int quantityInList = itemQuantity.get(0);
        assertEquals(quantity, quantityInList);
    }
    
    /**
     * Test for the method addItem in class Sale.
     */
    @Test
    public void testAddItemItemAlreadyScanned() {
        SystemCreator creator = new SystemCreator();
        
        int quantity = 5;
        ItemDTO item = new ItemDTO(0.0, 1, "aa", 0.0, 1);
        
        Sale instance = new Sale();
        instance.addItem(item, quantity);
        instance.addItem(item, quantity);
        instance.addItem(item, quantity);
        ArrayList<Integer> itemQuantity = instance.getItemQuantityList(); 
        int quantityInList = itemQuantity.get(0);
        assertEquals(15, quantityInList);
    }
    
    /**
     * Test for the method addItem in class Sale.
     */
    @Test
    public void testAddItemNotScannedBefore() {
        SystemCreator creator = new SystemCreator();
        
        int quantityForItem = 5;
        int quantityForItemBanana = 2;
        ItemDTO item = new ItemDTO(0.0, 1, "aa", 0.0, 1);
        ItemDTO itemBanana = new ItemDTO(0.0, 2, "Banana", 0.0, 1);
        
        Sale instance = new Sale();
        instance.addItem(item, quantityForItem);
        instance.addItem(itemBanana, quantityForItemBanana);
        
        ArrayList<Integer> itemQuantity = instance.getItemQuantityList(); 
        int quantityInList = itemQuantity.get(1);
        assertEquals(quantityForItemBanana, quantityInList);
    }
    
    /**
     * Test of turnOnCashRegister method, of class Sale.
     */
    @Test
    public void testTurnOnCashRegister() {
        SystemCreator creator = new SystemCreator();
        
        
        Sale instance = new Sale();
        instance.turnOnCashRegister();
        
    }

    /**
     * Test of pay method, of class Sale.
     */
    @Test
    public void testPay() {
        SystemCreator creator = new SystemCreator();
        double payment = 50.0;
        Sale instance = new Sale();
        instance.turnOnCashRegister();
        
        ItemDTO item = new ItemDTO(20.0, 1, "aa", 0.0, 1);
        instance.addItem(item, 1);
        double expResult = 25.0;
        double result = instance.pay(payment, payment);
        assertEquals(expResult, result, 0.0);
    }
    
}