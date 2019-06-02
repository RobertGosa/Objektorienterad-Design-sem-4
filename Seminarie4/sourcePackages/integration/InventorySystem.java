package integration;

import model.ItemDTO;
import model.Sale;

public class InventorySystem {
	ItemDTO inventory[] = new ItemDTO[3];
	
	public InventorySystem() {
		inventory[0] = new ItemDTO(10.0, 0, "Banan", 12.5, 0);
		inventory[1] = new ItemDTO(15.0, 1, "Äpple", 12.5, 0);
		inventory[2] = new ItemDTO(8.5, 2, "Apelsin", 12.5, 0);
	}
	
	public ItemDTO findItem(int itemIdentifier) throws ItemNotFoundException, DatabaseErrorException {
        for(int i = 0; i < inventory.length; i++) {
            if (itemIdentifier == 4){
                throw new DatabaseErrorException();
            }    
            if(inventory[i].getItemIdentifier() == itemIdentifier) {
                return inventory[i];
            }
        }
        
        throw new ItemNotFoundException(itemIdentifier);
}
	
	public void saveSaleInformation(Sale sale) {
		
	}
}