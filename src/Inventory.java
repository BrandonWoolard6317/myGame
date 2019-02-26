import java.util.ArrayList;

public class Inventory {
    //private String itemName,itemDescription;
    private ArrayList<Items> inventory;

    public Inventory() {

        inventory = new ArrayList<Items>();
    }


    public void addItem(Items item) {
        inventory.add(item);
    }

    public void removeItem(Items item) {
        inventory.remove(item);
    }


    public ArrayList<Items> getInventory(){
        return inventory;
    }
}




