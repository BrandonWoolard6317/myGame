public class Items {
    private static String itemName,itemDescription;

    public Items(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public static void pickupItem() {
        //if (Integer == 0) {
            System.out.println("You picked up the " + itemName);
        //}
    }

    @Override
    public String toString() {
        return itemName+", which is used to " + itemDescription+".";
    }
}
