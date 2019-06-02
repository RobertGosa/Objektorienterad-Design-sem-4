/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import model.ItemDTO;
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
public class InventorySystemTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    
    
    public InventorySystemTest() {
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
     * Test of findItem method, of class InventorySystem. It checks if the item description (String)
     * of the inventory[0] matches the item description of found item. The findItem method checks the
     * if the itemIdentifiers match, if it does it returns an item.
     * @throws DatabaseErrorException 
     */
    @Test
    public void testFindItem() throws ItemNotFoundException, DatabaseErrorException{
        ItemDTO inventory[] = new ItemDTO[1];
        inventory[0] = new ItemDTO(10.0, 0, "Banan", 12.5, 0);
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 0;
        String foundItemDescription = inventorySystem.findItem(itemIdentifier).getItemDescription();
        assertEquals(inventory[0].getItemDescription(), foundItemDescription);
    }
    
    /**
     * Test for the method findItem, in the class InventorySystem. 
     * @throws DatabaseErrorException 
     */
    @Test
    public void testFindItemNotExisting() throws ItemNotFoundException, DatabaseErrorException{
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 5;
        
        try {
            ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
        } catch (ItemNotFoundException exc) {
            assertTrue("Wrong exception message.", exc.getMessage()
                .contains("Unable to find item with the corresponding itemidentifer: " + itemIdentifier));
        }
    }

    @Test
    public void testFindItemDatabaseError() throws ItemNotFoundException, DatabaseErrorException {
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 4;
        
        try {
            ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
        } catch (DatabaseErrorException exc) {
            assertTrue("Wrong exception message.", exc.getMessage()
                .contains("Item with ID: \" + itemIdentifier + \" not found."));
        }
    }
    /**
     * Test of saveSaleInformation method, of class InventorySystem.
     */
    @Test
    public void testSaveSaleInformation() {
        System.out.println("saveSaleInformation");
        Sale sale = null;
        InventorySystem instance = new InventorySystem();
        instance.saveSaleInformation(sale);
        
        String expResult = "(Inventorysystem updated)";
        String result = outContent.toString();
        assertTrue(result.contains(expResult));
    }
    
    
    
}