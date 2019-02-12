import java.util.Scanner;

public class Main {

    public static Locations currentLocation;
    public static void main(String[] args) {
        Locations locationManayi = new Locations("Manayi", "Cold and dusty!");
        Locations locationMordox = new Locations("Mordox", "Hot and Dry!");
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
        locationMordox.addItem(new Items("Brass Key","unlock the door to go to Manayi"));
        currentLocation = locationManayi;

        System.out.println(currentLocation);

        while(true){
            takeCommands(new Scanner(System.in));
            System.out.println(currentLocation);
        }
    }

    public static void takeCommands(Scanner keyboard) {
        System.out.println("What do you want to do");
        String choice = keyboard.nextLine().toUpperCase();

        switch (choice) {
            case "NORTH":
            case "N":
                currentLocation = currentLocation.getExit(Direction.North);
                break;
            case "SOUTH":
            case "S":
                currentLocation = currentLocation.getExit(Direction.South);
                break;
            case "HELP":
                System.out.println("Printing help method");
                break;
            case "INV":
                System.out.println("Printing inventory");
                break;
            case "ITEMS":
                System.out.println(currentLocation.listItems());
                break;
        }

    }
}
