import java.util.Scanner;

public class Main {

    public static Locations currentLocation;
    public static void main(String[] args) {
        Locations locationManayi = new Locations("Manayi", "Cold and dusty!");
        Locations locationMordox = new Locations("Mordox", "Hot and Dry!");
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
        Items brassKey = new Items("Brass Key","unlock the door to go to Manayi");
        currentLocation = locationManayi;
        System.out.println(currentLocation);
        while(true){
            takeCommands(new Scanner(System.in));
            System.out.println(currentLocation);
        }
    }

    public static void takeCommands(Scanner keyboard) {
        System.out.println("What do you want to do");
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
                System.out.println("Printing help method");
                break;
            case "inv":
            case "i":
                System.out.println();
                break;
            case "items":
                System.out.println(currentLocation.listItems());
                break;
            case "pickup key":
            case "pickup brass key":

                Items.pickupItem();
                currentLocation.removeItem(null);
                Invetory brassKey = new Invetory("Brass Key","unlock the door to go to Manayi");
                brassKey.addInvetory(brassKey);
                break;
        }

    }
}
