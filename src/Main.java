import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        int k = 0;

        boolean loopAll,loopManayi,loopMordox,loopKey,loopUnlockDoor;
        loopAll = true;
        loopManayi = true;
        loopMordox = false;
        loopKey = false;
        loopUnlockDoor = false;

        Locations locationManayi = new Locations("Manayi","Cold and dusty!");
        possibleDirections directionsManayi = new possibleDirections(Direction.North,Direction.East,Direction.West);
        Locations locationMordox = new Locations("Mordox","Hot and Dry!");
        possibleDirections directionsMordox = new possibleDirections(Direction.South,Direction.East,Direction.West);
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
        Items Key = new Items("Brass Key","open the door to Manayi.");

        System.out.println(locationManayi);
        System.out.println(directionsManayi.toString());
        System.out.println("What direction do you want to go?");
        while(loopAll) {
            while (loopManayi) {
                userInput = scanner.nextLine().toLowerCase();
                switch (userInput) {
                    case "north":
                        System.out.println("Opened wooden door and went into Mordox.");
                        loopManayi = false;
                        loopMordox = true;
                        System.out.println(locationMordox);
                        System.out.println(directionsMordox.toString());
                        if(k<7) {
                            loopKey = true;
                            System.out.println("There's a brass key on the floor.");
                        }
                        System.out.println("What direction do you want to go?");
                        break;
                    case "south":
                        System.out.println("There's a wall behind you!");
                        break;
                    case "east":
                        System.out.println("Started walking east.");
                        loopManayi = false;
                        break;
                    case "west":
                        System.out.println("Started walking west.");
                        loopManayi = false;
                        break;
                    default:
                        System.out.println("Improper command!");
                        break;
                }
            }

            while (loopMordox) {
                userInput = scanner.nextLine().toLowerCase();
                switch (userInput) {
                    case "south":
                        System.out.println("Opened wooden door and went into Manayi.");
                        loopMordox = false;
                        loopManayi = true;
                        System.out.println(locationManayi);
                        System.out.println(directionsManayi.toString());
                        System.out.println("What direction do you want to go?");
                        break;
                    case "north":
                        System.out.println("There's a wall in front of you!");
                        break;
                    case "east":
                        System.out.println("Started walking east.");
                        loopMordox = false;
                        break;
                    case "west":
                        System.out.println("Started walking west.");
                        loopMordox = false;
                        break;
                    case "pickup key":
                        break;
                    default:
                        System.out.println("Improper command!");
                        break;
                }
                while(loopKey){
                    switch (userInput) {
                        case "pickup key":
                            System.out.println(Key.pickupItem());
                            loopKey = false;
                            loopUnlockDoor = true;
                            k=7;
                            break;
                        default:
                            System.out.println("Improper command!");
                            break;
                    }
                }
                while(loopUnlockDoor){
                    switch (userInput){
                        case "unlock door":
                            System.out.println("The door back to Manayi is now unlocked!");
                            break;
                    }
                }
            }
        }
    }
}
