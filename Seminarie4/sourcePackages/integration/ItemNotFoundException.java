package integration;

/**
 * Thrown when the search for an item in the inventorysystem fails to return the searched item.
 * @author Robert Gosa
 */
public class ItemNotFoundException extends Exception {
    
    /**
     * Creates a new instance of the exception with a descriptive message
     * @param itemIdentifier - The itemidentifier that could not be found.
     */
    public  ItemNotFoundException (int itemIdentifier){
        super("Item with ID: " + itemIdentifier + " not found.");
    }
  
}