/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import model.Sale;
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
public class AccountingSystemTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    public AccountingSystemTest() {
    }
    
    
    @Before
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }
    
    
    
    /**
     * Test of saveSaleInformation method, of class AccountingSystem.
     */
    @Test
    public void testSaveSaleInformation() {
        
        Sale sale = null;
        AccountingSystem instance = new AccountingSystem();
        instance.saveSaleInformation(sale);
        String expResult = "(Accountingsystem updated)";
        String result = outContent.toString();
        assertTrue(result.contains(expResult));
    }
    
}