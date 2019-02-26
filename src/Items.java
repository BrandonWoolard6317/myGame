public class Items {
    private String itemName,itemDescription;

    public Items(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }



    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName+", which is used to " + itemDescription+".";
    }
}
