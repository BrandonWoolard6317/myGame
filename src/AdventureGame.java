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
        System.out.println("What's your character's name?");
        currentLocation = locationManayi;
        System.out.println("Type Help or ? to get a list of commands!");
        while (true) {
            for (Items item : playerInventory.getInventory()) {
                pI = "" + item.toString();
            }
            System.out.println(currentLocation);
            takeCommands(new Scanner(System.in));
        }
    }

    @Override
    public String toString() {
        return ""+playerInventory.getInventory();
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
        Scanner reader = new Scanner("Rooms.txt");
        Locations[] locationList = new Locations[reader.nextInt()];
        for(int i=0;i<locationList.length;i++){
            reader.nextLine();
            String locationName = reader.nextLine();
            String locationDescription = reader.nextLine();
            boolean darkRoom = reader.nextBoolean();
            String darkRoomDescription;
            String leadsTo1 = reader.nextLine();
            String exitDescription1 = reader.nextLine();
            String dir1 = reader.nextLine();
            String leadsTo2 = reader.nextLine();
            String exitDescription2 = reader.nextLine();
            String dir2 = reader.nextLine();
            String leadsTo3 = reader.nextLine();
            String exitDescription3 = reader.nextLine();
            String dir3 = reader.nextLine();
            Direction direction1 = null;
            Direction direction2 = null;
            Direction direction3 = null;
            switch (dir1) {
                case "north":
                    direction1 = Direction.North;
                    break;
                case "south":
                    direction1 = Direction.South;
                    break;
                case "east":
                    direction1 = Direction.East;
                    break;
                case "west":
                    direction1 = Direction.West;
                    break;
            }
            switch (dir2) {
                case "north":
                    direction2 = Direction.North;
                    break;
                case "south":
                    direction2 = Direction.South;
                    break;
                case "east":
                    direction2 = Direction.East;
                    break;
                case "west":
                    direction2 = Direction.West;
                    break;
            }
            switch (dir3) {
                case "north":
                    direction3 = Direction.North;
                    break;
                case "south":
                    direction3 = Direction.South;
                    break;
                case "east":
                    direction3 = Direction.East;
                    break;
                case "west":
                    direction3 = Direction.West;
                    break;
            }
            if(darkRoom){
                darkRoomDescription = reader.nextLine();
                locationList[i] = new Locations(locationName,locationDescription,darkRoom,darkRoomDescription,exitDescription1,direction1);
            }
            else {
                locationList[i] = new Locations(locationName,locationDescription);
            }
        }
        /*locationManayi = new Locations("Manayi", "Cold and dusty!");
        locationMordox = new Locations("Mordox", "Hot and Dry!");
        locationYatia = new Locations("Yatia","Ancient symbols on wall.",true,"Wet and Musty!");
        locationKenya = new Locations("Kenya","Unknown");
        locationOnsid = new Locations("Onsid","Unknown");*/
    }

    private void createExits() {
        /*Scanner reader = new Scanner("Exits.txt");
        Items[] exitsList = new Items[reader.nextInt()];
        for(int i=0;i<exitsList.length;i++){
            reader.nextLine();
            String description = reader.nextLine();
            Direction direction = reader.nextLine();
            Locations locations = reader.nextLine();
            boolean locked = reader.nextBoolean();
            if(locked){
                Items item = reader.nextLine();
                String actionString = reader.nextLine();
                exitsList[i] = new Exit(description,direction,locations,locked,item,actionString);
            }
            else {
                exitsList[i] = new Exit(description,direction,locations);
            }
        }*/

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
        locationMordox.addItem(batteries);
        locationMordox.addItem(flashLight);
    }

    private void createItems() {
        /*Scanner reader = new Scanner("Items.txt");
        Items[] itemsList = new Items[reader.nextInt()];
        for(int i=0;i<itemsList.length;i++){
            reader.nextLine();
            String itemName = reader.nextLine();
            String itemDescription = reader.nextLine();
            String inventoryDescription = reader.nextLine();
            boolean itemCombine = reader.nextBoolean();
            if(itemCombine){
                String item1 = reader.nextLine();
                String item2 = reader.nextLine();
                itemsList[i] = new Items(itemName,itemDescription,inventoryDescription,itemCombine,item1,item2);
            }
            else {
                itemsList[i] = new Items(itemName,itemDescription,inventoryDescription,itemCombine);
            }
        }*/
        knife = new Items("Gold Knife", "Used to cut things","Has silver engraving in a different language",false);
        brassKey = new Items("Brass Key", "An old used up key","Can unlock the door to go to Yatia",false);
        batteries = new Items("Batteries","Used to power something up","AA Batteries",true,flashLight,poweredFlashLight);
        flashLight = new Items("Flashlight","Used to see in dark areas","Needs AA Batteries",true,batteries,poweredFlashLight);
        poweredFlashLight = new Items("Powered Flashlight","Used to see in dark areas","Needs AA Batteries",true,batteries,poweredFlashLight);
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