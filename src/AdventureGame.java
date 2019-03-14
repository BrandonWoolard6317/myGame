import java.util.Scanner;

public class AdventureGame {

    public Locations currentLocation,locationMordox,locationManayi,locationYatia,locationKenya,locationOnsid;
    public Inventory playerInventory;
    public Items knife,brassKey;
    public Exit maToMo,moToMa,moToYa,yaToMo,yaToKe,keToYa,keToOn,onToKe;
    public static Direction currentDirection;

    public AdventureGame() {
        init();
        System.out.println("Type Help or ? to get a list of commands!");
        currentLocation = locationManayi;
        while (true) {
            System.out.println(currentLocation);
            takeCommands(new Scanner(System.in));
        }
    }

    private void init() {
        createPlayerInventory();
        createLocations();
        createItems();
        createExits();
    }

    private void createPlayerInventory() {
        playerInventory = new Inventory();
    }

    private void createLocations() {
        locationManayi = new Locations("Manayi", "Cold and dusty!");
        locationMordox = new Locations("Mordox", "Hot and Dry!");
        locationYatia = new Locations("Yatia","Wet and Musty!");
        locationKenya = new Locations("Kenya","Unknown");
        locationOnsid = new Locations("Onsid","Unknown");
    }

    private void createExits() {
        maToMo = new Exit("Wood door", Direction.North, locationMordox);
        moToMa = new Exit("Wood door", Direction.South, locationManayi);
        moToYa = new Exit("Metal door", Direction.East, locationYatia);
        yaToMo = new Exit("Metal Door", Direction.West, locationMordox);
        yaToKe = new Exit("Gold Door",Direction.North,locationKenya);
        keToYa = new Exit("Gold Door", Direction.South, locationYatia);
        keToOn = new Exit("Gold Door",Direction.East,locationKenya,true,brassKey,"Unlocked door to Onsid.");
        locationManayi.addExit(maToMo);
        locationMordox.addExit(moToMa);
        locationMordox.addExit(moToYa);
        locationYatia.addExit(yaToMo);
        locationYatia.addExit(yaToKe);
        locationKenya.addExit(keToYa);
        locationKenya.addExit(keToOn);
        locationKenya.addItem(brassKey);
        keToOn.setInteractiveItem(brassKey);
        locationManayi.addItem(knife);
    }

    private void createItems() {
        knife = new Items("Gold Knife", "Used to cut things","Has silver engraving in a different language");
        brassKey = new Items("Brass Key", "An old used up key","Can unlock the door to go to Yatia");
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
                    currentDirection = Direction.North;
                    break;
                }
                break;
            case "east":
            case "e":
                if (!currentLocation.checkedLockedState(Direction.East)) {
                    currentLocation = currentLocation.getExit(Direction.East);
                    currentDirection = Direction.East;
                    break;
                }
            case "south":
            case "s":
                if (!currentLocation.checkedLockedState(Direction.South)) {
                    currentLocation = currentLocation.getExit(Direction.South);
                    currentDirection = Direction.South;
                    break;
                }
            case "west":
            case "w":
                if (!currentLocation.checkedLockedState(Direction.West)) {
                    currentLocation = currentLocation.getExit(Direction.West);
                    currentDirection = Direction.West;
                    break;
                }
            case "help":
            case "?":
                System.out.println("Directions\n------------------------\nN or North to go North\nE or East to go" +
                        " East\nS or South to go South\nW or West to go West\n\nOther\n------------------------\nInv/Items/I to open Inventory\n" +
                        "Take to take an item\nUse to use an item");
                break;
            case "inv":
            case "items":
            case "i":
                for (Items item : playerInventory.getInventory()) {
                    System.out.println(item.toString() + "\n");
                }
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
                if (checkItemsInInventory(options)) {
                    String additionalWord;
                    additionalWord = options[2] != null ? " " + options[2] : "";
                    System.out.println("Used " + options[1] + additionalWord);
                    usedItem(options,currentDirection);
                } else {
                    System.out.println("Cannot use the item here");
                }
                break;
            case "description":
                for(Items item : playerInventory.getInventory()){
                    item.getItemDescription();
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
                item.changeDescription();
                return true;
            }else if ((options[1] + " " + options[2]).equals(item.getItemName().toLowerCase())) {
                currentLocation.removeItem(item);
                playerInventory.addItem(item);
                item.changeDescription();
                return true;
            }
        }
        return false;
    }

    public boolean checkItemsInInventory(String[] options) {
        for (Items item : playerInventory.getInventory()) {
            if (options[1].equals(item.getItemName().toLowerCase())) {
                currentLocation.removeItem(item);
                playerInventory.addItem(item);
                return true;
            }else if ((options[1] + " " + options[2]).equals(item.getItemName().toLowerCase())) {
                currentLocation.removeItem(item);
                playerInventory.addItem(item);
                return true;
            }
        }
        return false;
    }

    public boolean usedItem(String[] options, Direction direction) {
        for (Items item : playerInventory.getInventory()) {
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
