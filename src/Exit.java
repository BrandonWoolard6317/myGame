public class Exit {
    private String description;
    private Direction direction;
    private Locations leadsTo;
    private boolean locked;
    private Items interactiveItem;

    public Exit(String description, Direction direction, Locations leadsTo) {
        this.description = description;
        this.direction = direction;
        this.leadsTo = leadsTo;
        this.locked = false;
    }

    public Exit(String description, Direction direction, Locations leadsTo, boolean locked, Items interactiveItem) {
        this.description = description;
        this.direction = direction;
        this.leadsTo = leadsTo;
        this.locked = locked;
    }

    public void setInteractiveItem(Items interactiveItem){
        this.interactiveItem = interactiveItem;
    }

    @Override
    public String toString() {
        String text = "  "+description + " that leads " +
                direction +
                " to " + leadsTo.getLocationName() +
                ". ";
        return text;
    }

    public Direction getDirection() {
        return direction;
    }

    public Locations getLeadsTo() {
        return leadsTo;
    }

    public boolean isLocked() {
        return locked;
    }

    public Items getInteractiveItem() {
        return interactiveItem;
    }

    public boolean unLock(Items item) {
        if(item==interactiveItem) {
            System.out.println("The item was correctly used");
            this.locked = false;
        }
        return true;

        /*if(!this.locked){
            return true;
        }

        if(item == null){
            System.out.println("Item does not exist to unlcok");
            return false;
        }

        if(item == interactiveItem){
            System.out.println("The item was correctly used");
            this.locked = !this.locked;
            return true;
        }
        else{
            return false;
        }*/
    }
}
