import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        boolean loopAll,loopManayi,loopMordox;
        loopAll = true;
        loopManayi = true;
        loopMordox = false;

        Locations locationManayi = new Locations("Manayi","Cold and dusty!");
        possibleDirections directionsManayi = new possibleDirections(Direction.North,Direction.East,Direction.West);
        Locations locationMordox = new Locations("Mordox","Hot and Dry!");
        possibleDirections directionsMordox = new possibleDirections(Direction.South,Direction.East,Direction.West);
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi));
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
                    default:
                        System.out.println("Improper command!");
                        break;
                }
            }
        }
    }
}
