package model;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 * Test for the methods in the CashRegister class.
 * @author Robert Gosa
 */
public class CashRegisterTest {
    
    public CashRegisterTest() {
    }
    

    /**
     * Test of addPayment method, of class CashRegister.
     */
    @Test
    public void testAddPayment() {
        double payment = 30.5;
        CashRegister instance = new CashRegister();
        instance.addPayment(payment);
        assertEquals(30.5, instance.getBalance());
    }
    
    /**
     * Test for the addPayment method, with negative input.
     */
    @Test
    public void testAddPaymentWithNegativeDouble() {
        double payment = -10.5;
        CashRegister instance = new CashRegister();
        instance.addPayment(payment);
        assertEquals(-10.5, instance.getBalance());
    }
    
    /**
     * Test of calculateChange method, of class CashRegister.
     */
    @Test
    public void CalculateChangeTest() {
        double payment = 35.0;
        double cost = 25.0;
        CashRegister instance = new CashRegister();
        double expResult = 10.0;
        double result = instance.calculateChange(payment, cost);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of the calculateChange method, with a payment of zero.
     */
    @Test
    public void testCalculateChangeWithPaymentZero(){
        double payment = 0.0;
        double cost = 25.0;
        CashRegister instance = new CashRegister();
        double expResult = -25.0;
        double result = instance.calculateChange(payment, cost);
        assertEquals(expResult, result);
    }
    
}