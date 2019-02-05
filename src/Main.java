public class Main {
    public static void main(String[]args){
        Locations location1 = new Locations("Manayi","Cold and dusty!");
        Locations location2 = new Locations("Mordox","Hot and Dry!");
        location1.addExit(new Exit("Wood door", Direction.North, location2));
        location2.addExit(new Exit("Wood door", Direction.South, location1));
        System.out.println(location1);
        System.out.println(location2);
    }
}
