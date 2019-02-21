import java.util.Scanner;

public class Main {
    public static Items brassKey;
    public static Locations currentLocation;
    public static Invetory iBrassKey,iStick;
    static int i = 0;
    public static void main(String[] args) {
        Locations locationManayi = new Locations("Manayi", "Cold and dusty!");
        Locations locationMordox = new Locations("Mordox", "Hot and Dry!");
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
        //locationMordox.getExit(new Exit());
        brassKey = new Items("Brass Key","unlock the door to go to Manayi");
        locationMordox.addItem(brassKey);
        currentLocation = locationManayi;
        System.out.println(currentLocation);
        while(true){
            takeCommands(new Scanner(System.in));
            System.out.println(currentLocation);
        }
    }

    public static void takeCommands(Scanner keyboard) {
        System.out.println("What do you want to do?");
        String choice = keyboard.nextLine().toLowerCase();
        switch (choice) {
            case "north":
            case "n":
                currentLocation = currentLocation.getExit(Direction.North);
                break;
            case "east":
            case "e":
                currentLocation = currentLocation.getExit(Direction.East);
                break;
            case "south":
            case "s":
                currentLocation = currentLocation.getExit(Direction.South);
                break;
            case "west":
            case "w":
                currentLocation = currentLocation.getExit(Direction.West);
                break;
            case "help":
            case "?":
                System.out.println("Directions\n------------------------\nN or North to go North\nE or East to go East\nS or South to go South\nW or West to go West\n");
                break;
            case "inv":
            case "i":
                System.out.println(Invetory.listInvetory());
                break;
            case "items":
                System.out.println(currentLocation.listItems());
                break;
            case "pickup key":
            case "pickup brassKey":
                if(i==0){
                    brassKey.pickupItem();
                    currentLocation.removeItem(brassKey);
                    iBrassKey = new Invetory("Brass Key", "unlock the door to go to Juda");
                    Invetory.addInvetory(iBrassKey);
                }else{
                    System.out.println("You already picked up the key!");
                }
                i = 3;
                break;
        }

    }
}
