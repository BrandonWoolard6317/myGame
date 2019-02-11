import java.util.Scanner;

public class Main {

    public static Locations currentLocation;
    public static void main(String[] args) {
        Locations locationManayi = new Locations("Manayi", "Cold and dusty!");
        possibleDirections directionsManayi = new possibleDirections(Direction.North, Direction.East, Direction.West);
        Locations locationMordox = new Locations("Mordox", "Hot and Dry!");
        possibleDirections directionsMordox = new possibleDirections(Direction.South, Direction.East, Direction.West);
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
        Items Key = new Items("Brass Key", "open the door to Manayi.");
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
        }

    }
}
