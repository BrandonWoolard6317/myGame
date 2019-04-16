import java.util.ArrayList;

public class Locations {
    private String locationName,locationsDescription,b25,b26;
    private ArrayList<Exit> exits;
    private Inventory items;


    public Locations(String locationName, String locationDescription){
        this.locationName = locationName;
        this.locationsDescription = locationDescription;
        exits = new ArrayList<Exit>();
        items = new Inventory();
    }

    public Locations(String locationName, String locationsDescription, boolean darkRoom, String darkRoomDescription,String exit1Name,Direction exit1Direction,Locations leadsTo) {
        exits = new ArrayList<Exit>();
        items = new Inventory();
        this.b25 = locationsDescription;
        this.b26 = locationName;
        if(darkRoom){
            this.locationName = "Unknown(Too Dark)";
            this.locationsDescription = darkRoomDescription;
        }else{
            this.locationName = locationName;
            this.locationsDescription = locationsDescription;
        }
    }

    public Locations(String locationName, String locationsDescription, boolean darkRoom, String darkRoomDescription,String exit1Name,Direction exit1Direction,String exit2Name,Direction exit2Direction,String exit3Name,Direction exit3Direction) {
        exits = new ArrayList<Exit>();
        items = new Inventory();
        this.b25 = locationsDescription;
        this.b26 = locationName;
        if(darkRoom){
            this.locationName = "Unknown(Too Dark)";
            this.locationsDescription = darkRoomDescription;
        }else{
            this.locationName = locationName;
            this.locationsDescription = locationsDescription;
        }
    }

    public Locations(String locationName, String locationsDescription, boolean darkRoom, String darkRoomDescription,String exit1Name,Direction exit1Direction,String exit2Name,Direction exit2Direction) {
        exits = new ArrayList<Exit>();
        items = new Inventory();
        this.b25 = locationsDescription;
        this.b26 = locationName;
        if(darkRoom){
            this.locationName = "Unknown(Too Dark)";
            this.locationsDescription = darkRoomDescription;
        }else{
            this.locationName = locationName;
            this.locationsDescription = locationsDescription;
        }
    }

    public Locations(String locationName, String locationsDescription, boolean darkRoom, String darkRoomDescription){
        exits = new ArrayList<Exit>();
        items = new Inventory();
        this.b25 = locationsDescription;
        this.b26 = locationName;
        if(darkRoom){
            this.locationName = "Unknown(Too Dark)";
            this.locationsDescription = darkRoomDescription;
        }else{
            this.locationName = locationName;
            this.locationsDescription = locationsDescription;
        }
    }

    public void addExit(Exit exit){
        exits.add(exit);
    }

    @Override
    public String toString() {
        String currentDirection;
        String playername;
        String items;
        String theDirection="                  "+AdventureGame.currentDirection;
        if(AdventureGame.currentDirection==null){
            currentDirection = "";
        }else{
            currentDirection="\n-----------------------------------------\n"+
                    "                 Direction"+
                    "\n-----------------------------------------\n"+
                    theDirection+
                    "\n-----------------------------------------";
        }

        if(AdventureGame.playerName==null){
            playername = "";
        }else{
            playername="-----------------------------------------\n"
                    +"               Player Name\n"
                    +"-----------------------------------------\n"+
                    "                 "+AdventureGame.playerName+
                    "\n-----------------------------------------\n";
        }

        if(listItems()==null){
            items="";
        }else{
            items="\n-----------------------------------------\n"+
                    "                 Items"+
                    "\n-----------------------------------------\n"+
                    this.listItems()+
                    "\n-----------------------------------------";
        }

        String playerInventory;
            if(AdventureGame.pI==null){
                playerInventory="";
            }else {
                playerInventory = "\n-----------------------------------------\n" +
                        "           Player Inventory" +
                        "\n-----------------------------------------\n" +
                        AdventureGame.pI +
                        "\n-----------------------------------------";
            }

        String text = playername+
                "-----------------------------------------\n"+
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
                currentDirection+
                items+playerInventory;

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

    public void lightRoom(){
        this.locationName = this.b26;
        this.locationsDescription = this.b25;
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
