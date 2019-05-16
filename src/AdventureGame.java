import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventureGame {

    public Locations currentLocation,locationMordox,locationManayi,locationYatia,locationKenya,locationOnsid;

    public Inventory playerInventory;
    public Items knife,brassKey,batteries,flashLight,poweredFlashLight;
    public Exit maToMo,moToMa,moToYa,yaToMo,yaToKe,keToYa,keToOn,onToKe;
    public static Direction currentDirection;
    public static String playerName,lightHelp="";
    public static String pI;

    public AdventureGame() {
        init();
        //System.out.println("What's your character's name?");
        //currentLocation = locationManayi;
        System.out.println("Type Help or ? to get a list of commands!");
        while (true) {
            for (Items item : playerInventory.getInventory()) {
                pI = "" + item.toString();
            }
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



    @Override
    public String toString() {
        return "AdventureGame{" +
                "currentLocation=" + currentLocation +
                ", locationMordox=" + locationMordox +
                ", locationManayi=" + locationManayi +
                ", locationYatia=" + locationYatia +
                ", locationKenya=" + locationKenya +
                ", locationOnsid=" + locationOnsid +
                ", playerInventory=" + playerInventory +
                ", knife=" + knife +
                ", brassKey=" + brassKey +
                ", batteries=" + batteries +
                ", flashLight=" + flashLight +
                ", poweredFlashLight=" + poweredFlashLight +
                ", maToMo=" + maToMo +
                ", moToMa=" + moToMa +
                ", moToYa=" + moToYa +
                ", yaToMo=" + yaToMo +
                ", yaToKe=" + yaToKe +
                ", keToYa=" + keToYa +
                ", keToOn=" + keToOn +
                ", onToKe=" + onToKe +
                '}';
    }

    private void createLocations() {
        File file = new File("Rooms.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE DOES NOT EXIST");
        }

        int locations = reader.nextInt();
        Locations[] locationList = new Locations[locations];
        for(int i=0;i<locationList.length;i++){
            reader.nextLine();
            String locationName = reader.nextLine();
            String locationDescription = reader.nextLine();

            boolean darkRoom = reader.nextBoolean();

            if(darkRoom){
                locationList[i] = new Locations(locationName,locationDescription,darkRoom,reader.nextLine());
            }
            else {
                locationList[i] = new Locations(locationName,locationDescription);
            }

            if(i==0){
                currentLocation = locationList[0];
            }

           // System.out.println(locationList[i]);
        }
    }

    private void createExits() {
        File file = new File("Exits.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE DOES NOT EXIST");
        }
        String der = null;
        Direction exitDirection = Direction.North;
        int exits = reader.nextInt();
        Exit[] exitList = new Exit[exits];
        for (int i = 0; i < exitList.length; i++) {
            reader.nextLine();
            String exitDescription = reader.nextLine();
            der = reader.nextLine();
            String locationOfExit = reader.nextLine();
            Boolean lockedDoor = reader.nextBoolean();
            Locations location = null;
            String item = "";
            String actionString = "";
            Items keyItem = null;
            if (lockedDoor == true) {
                item = reader.nextLine();
                actionString = reader.nextLine();
            }
            switch (der) {
                case "North":
                    exitDirection = Direction.North;
                    break;
                case "South":
                    exitDirection = Direction.South;
                    break;
                case "East":
                    exitDirection = Direction.East;
                    break;
                case "West":
                    exitDirection = Direction.West;
                    break;
            }
            if (lockedDoor == true) {
                exitList[i] = new Exit(exitDescription, exitDirection, location, true, keyItem, actionString);
            } else {
                exitList[i] = new Exit(exitDescription, exitDirection, location);
            }
        }
    }

    private void createItems() {
        File file = new File("Items.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE DOES NOT EXIST");
        }
        int items = reader.nextInt();
        Items[] itemList = new Items[items];
        for (int i = 0; i < itemList.length; i++) {
            reader.nextLine();
            String itemName = reader.nextLine();
            String itemDescription = reader.nextLine();
            String inventoryDescription = reader.nextLine();
            Boolean itemCombine = reader.nextBoolean();
            Items item1 = null;
            Items item2 = null;
            if (itemCombine == true) {
                itemList[i] = new Items(itemName, itemDescription, inventoryDescription, true, item1, item2);
            } else {
                itemList[i] = new Items(itemName, itemDescription, inventoryDescription, false);
            }
        }
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
                System.out.println("Directions\n------------------------\nN/North: To go North\nE/East: To go" +
                        " East\nS/South: To go South\nW/West: To go West\n\nOther\n------------------------\nInv/Items/I: To open Inventory\n" +
                        "Take: To take an item\nUse: To use an item\nPlayerName/ChangeName/ChangePlayerName: To change your character's name"+lightHelp);
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
                    for (Items item : playerInventory.getInventory()) {
                        System.out.println("Taken " + item.getItemName());
                    }
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
            case "playername":
            case "changename":
            case "changeplayername":
                String a;
                System.out.println("Do you want to change your name?");
                a = keyboard.nextLine().toLowerCase();
                if(a.equals("yes")){
                    changePlayerName();
                }else if(a.equals("no")) {
                    return;
                }
                break;
            case "combine":
                String b;
                System.out.println("What is the 1st Item?");
                a=keyboard.nextLine();
                System.out.println("What is the 2nd Item?");
                b=keyboard.nextLine();
                if(playerInventory.getInventory().contains(flashLight)&&playerInventory.getInventory().contains(batteries)){
                    if(a.equals("batteries")&&b.equals("flashlight")){
                    itemCombine(batteries,flashLight,poweredFlashLight);
                    lightHelp = "\nLight/Flashlight: To light a dark room up";
                    System.out.println("You unlocked a new command!");
                    }else if(a.equals("flashlight")&&b.equals("batteries")) {
                    itemCombine(batteries, flashLight, poweredFlashLight);
                    lightHelp = "\nLight/Flashlight: To light a dark room up";
                    System.out.println("You unlocked a new command!");
                    }
                }
                break;
            case "light":
            case "flashlight":
                if(playerInventory.getInventory().contains(poweredFlashLight)){
                    currentLocation.lightRoom();
                    System.out.println("You've lightened up this room!");
                }
                break;
            case "boom":
                playerInventory.addItem(poweredFlashLight);
                break;
            default:
                System.out.println("We have not received the correct input");
                break;
        }
    }

    public boolean checkItemsInLocation(String[] options) {
        for (Items item : currentLocation.getInventory()) {
            if (item.getItemName().contains(options[options.length-1])) {
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
    public void changePlayerName(){
        System.out.println("What's your character's name?");
        Scanner a = new Scanner(System.in);
        playerName = a.nextLine();
    }
    public void itemCombine(Items item1,Items item2,Items combinedItem){
        if(playerInventory.getInventory().contains(item1)&&playerInventory.getInventory().contains(item2)) {
            playerInventory.removeItem(item1);
            playerInventory.removeItem(item2);
            playerInventory.addItem(combinedItem);
        }
    }
}