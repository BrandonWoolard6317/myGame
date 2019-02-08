public class Items {
    private String itemName,itemDescription;

    public Items(String itemName) {
        this(itemName,"");
    }

    public Items(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String pickupItem(){
        return "You picked up a "+itemName+", which is used to "+itemDescription;
    }
}
