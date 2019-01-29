public class Locations {
    private String locationName,locationsDescription,Exit1,Exit2;

    public Locations(String locationName, String locationsDescription, String Exit1) {
        this(locationName,locationsDescription,Exit1,"");
    }
    public Locations(String locationName, String locationDescription, String Exit1, String Exit2){
        this.locationName = locationName;
        this.locationsDescription = locationDescription;
        this.Exit1 = Exit1;
        this.Exit2 = Exit2;
    }

    @Override
    public String toString() {
        return  "-------------------------------\n"+
                "         Location Name"+
                "\n-------------------------------\n"+
                "            "+locationName+
               "\n-------------------------------\n"+
                "-------------------------------\n"+
                "      Location Description"+
               "\n-------------------------------\n"+
                "        "+locationsDescription+
               "\n-------------------------------";
    }

    public String listExits(){
        return Exit1+" "+Exit2;
    }
}
