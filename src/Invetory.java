import java.util.ArrayList;

public class Invetory {
    private String itemName,itemDescription;
    private static ArrayList<Invetory> invetory;

    public Invetory(String itemName,String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        invetory = new ArrayList<Invetory>();
    }
    public static void addInvetory(Invetory theInvetory){
        invetory.add(theInvetory);
    }
    public static String listInvetory(){
        String invetoryList = "";
        for(Invetory theInvetory : invetory){
            invetoryList = invetoryList + theInvetory.toString();
        }
        return invetoryList;
    }
    @Override
    public String toString() {
        return itemName+", which is used to " + itemDescription+".";
    }
}
