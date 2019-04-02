public class Items {
    private String itemName,itemDescription,inventoryDescription;
    private Items compatibleItem,endProduct;

    public Items(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public Items(String itemName, String itemDescription, String inventoryDescription, boolean itemCombine) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.inventoryDescription = inventoryDescription;
    }

    public Items(String itemName, String itemDescription, String inventoryDescription, boolean itemCombine, Items compatibleItem,Items endProduct) {
        this.itemName = itemName.toLowerCase();
        this.itemDescription = itemDescription;
        this.inventoryDescription = inventoryDescription;
        if(itemCombine==true){
            this.compatibleItem = compatibleItem;
            this.endProduct = endProduct;
        }
    }

    public void changeDescription(){
        if(inventoryDescription==null){
        }else {
            itemDescription = inventoryDescription;
        }
    }

    public Items getCompatibleItem() {
        return compatibleItem;
    }

    public String getItemName() {
        return itemName;
    }

    public Items getEndProduct() {
        return endProduct;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return itemName+": "+itemDescription+".";
    }
}
