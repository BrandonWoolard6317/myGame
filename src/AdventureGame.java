import java.util.Scanner;

public class AdventureGame {

    public Locations currentLocation, locationMordox, locationManayi;
    public Inventory playerInventory;


    public AdventureGame() {


        init();


        currentLocation = locationManayi;

        while (true) {
            System.out.println(currentLocation);
            takeCommands(new Scanner(System.in));


        }
    }

    private void init() {
        createPlayerInventory();
        createLocations();
        createExits();
        createItems();
    }

    private void createPlayerInventory() {
        playerInventory = new Inventory();
    }

    private void createLocations() {
        locationManayi = new Locations("Manayi", "Cold and dusty!");
        locationMordox = new Locations("Mordox", "Hot and Dry!");
    }

    private void createExits() {
        locationManayi.addExit(new Exit("Wood door", Direction.North, locationMordox, false));
        locationMordox.addExit(new Exit("Wood door", Direction.South, locationManayi, true));
    }

    private void createItems() {
        locationManayi.addItem(new Items("Knife", "Used to cut things"));
        locationMordox.addItem(new Items("Brass Key", "unlock the door to go to Manayi"));


    }

    public void takeCommands(Scanner keyboard) {
        System.out.println("What do you want to do?");
        String[] options = keyboard.nextLine().toLowerCase().split(" ");
        String choice = options[0];


        switch (choice) {
            case "north":
            case "n":
                if (!currentLocation.checkedLockedState(Direction.North)) {
                    currentLocation = currentLocation.getExit(Direction.North);
                    break;
                }
                break;
            case "east":
            case "e":
                currentLocation = currentLocation.getExit(Direction.East);
                break;
            case "south":
            case "s":
                if (!currentLocation.checkedLockedState(Direction.South)) {
                    currentLocation = currentLocation.getExit(Direction.South);
                    break;
                }
            case "west":
            case "w":
                currentLocation = currentLocation.getExit(Direction.West);
                break;
            case "help":
            case "?":
                System.out.println("Directions\n------------------------\nN or North to go North\nE or East to go" +
                        " East\nS or South to go South\nW or West to go West\n");
                break;
            case "inv":
            case "i":
                for (Items item : playerInventory.getInventory()) {
                    System.out.println(item.toString() + "\n");
                }

                break;
            case "items":
                System.out.println(currentLocation.listItems());
                break;
            case "take":

                if (checkItemsInLocation(options)) {
                    String additionalWord;
                    additionalWord = options[2] != null ? " " + options[2] : "";
                    System.out.println("Taken " + options[1] + additionalWord);
                } else {

                    System.out.println("That item is not here");
                }
                break;
            case "use":

                if (checkItemsInLocation(options)) {
                    String additionalWord;
                    additionalWord = options[2] != null ? " " + options[2] : "";
                    System.out.println("Used " + options[1] + additionalWord);
                } else {

                    System.out.println("Cannot use the item here");
                }
                break;
            default:
                System.out.println("We have not received the correct input");
                break;
        }

    }

    public boolean checkItemsInLocation(String[] options) {
        for (Items item : currentLocation.getInventory()) {
            if (options[1].equals(item.getItemName().toLowerCase())) {

                currentLocation.removeItem(item);
                playerInventory.addItem(item);
                return true;
            } else if ((options[1] + " " + options[2]).equals(item.getItemName().toLowerCase())) {
                currentLocation.removeItem(item);
                playerInventory.addItem(item);
                return true;
            }
        }
        return false;
    }

    public boolean usedItem(String[] options, Direction direction) {
        for (Items item : currentLocation.getInventory()) {
            if (options[1].equals(item.getItemName().toLowerCase())) {
                if (currentLocation.checkedLockedState(direction)) {
                    playerInventory.removeItem(item);
                    currentLocation.returnExit(direction).unLock(item);
                    return true;
                }
            }else if ((options[1] + " " + options[2]).equals(item.getItemName().toLowerCase())) {
                if (currentLocation.checkedLockedState(direction)) {
                    playerInventory.removeItem(item);
                    currentLocation.returnExit(direction).unLock(item);
                    return true;
                }
            }
        }
        return false;
    }
}
