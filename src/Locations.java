import java.util.ArrayList;

public class Locations {
    private String locationName,locationsDescription;
    private ArrayList<Exit> exits;
   // private ArrayList<Items> items;
    private Inventory items;


    public Locations(String locationName, String locationDescription){
        this.locationName = locationName;
        this.locationsDescription = locationDescription;
        exits = new ArrayList<Exit>();
        items = new Inventory();
    }

    public void addExit(Exit exit){
        exits.add(exit);
    }

    @Override
    public String toString() {
        String text = "-----------------------------------------\n"+
                "             Location Name"+
                "\n-----------------------------------------\n"+
                "                 "+locationName+
                "\n-----------------------------------------\n"+
                "-----------------------------------------\n"+
                "          Location Description"+
                "\n-----------------------------------------\n"+
                "             "+locationsDescription+
                "\n-----------------------------------------"+
                "\n-----------------------------------------\n"+
                "                 Exits"+
                "\n-----------------------------------------\n"+
                this.listExits()+
                "\n-----------------------------------------"+
                "\n-----------------------------------------\n"+
                "                 Items"+
                "\n-----------------------------------------\n"+
                this.listItems()+
                "\n-----------------------------------------";

        return text;
    }

    public String listExits(){
        String exitList = "";
        for(Exit exit : exits){
           exitList = exitList + exit.toString();
        }
        return exitList;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationsDescription() {
        return locationsDescription;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public Locations getExit(Direction direction){
        for(Exit exit: exits){
            if(exit.getDirection() == direction){
                return exit.getLeadsTo();
            }
        }
        return this;
    }

    public Exit returnExit(Direction direction){
        for(Exit exit: exits){
            if(exit.getDirection() == direction){

                return exit;
            }
        }
        return null;
    }

    public boolean checkedLockedState(Direction direction){
        for(Exit exit: exits){
            if(exit.getDirection() == direction){
                return exit.isLocked();
            }
        }
        return false;
    }



    public void addItem(Items item){
        items.addItem(item);
    }

    public void removeItem(Items item){
        items.removeItem(item);
    }

    public String listItems(){
        String itemList = "";

        for(Items item : this.items.getInventory()){

            itemList = itemList + item.toString() +"\n";

        }
        return itemList;
    }

    public ArrayList<Items> getInventory(){
        return this.items.getInventory();
    }
}
