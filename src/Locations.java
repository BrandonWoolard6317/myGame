import java.util.ArrayList;

public class Locations {
    private String locationName,locationsDescription;
    private ArrayList<Exit> exits;

    public Locations(String locationName, String locationDescription){
        this.locationName = locationName;
        this.locationsDescription = locationDescription;
        exits = new ArrayList<Exit>();
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
                listExits()+
                "\n-----------------------------------------\n\n";
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
}
