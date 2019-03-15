public class Items {
    private String itemName,itemDescription,inventoryDescription;

    public Items(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public Items(String itemName,String itemDescription,String inventoryDescription) {
        this.itemName = itemName.toLowerCase();
        this.itemDescription = itemDescription;
        this.inventoryDescription = inventoryDescription;
    }

    public void changeDescription(){
        if(inventoryDescription==null){
        }else {
            itemDescription = inventoryDescription;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return itemName+": "+itemDescription+".";
    }
}
