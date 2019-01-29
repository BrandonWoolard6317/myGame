public class Main {
    public static void main(String[]args){
        Locations location1 = new Locations("Manayi","Cold and dusty!","East","West");
        Locations location2 = new Locations("Mordox","Hot and Dry!","North");
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location1.listExits());
        System.out.println(location2.listExits());
    }
}
