public class Exit {
    private String description;
    private Direction direction;
    private Locations leadsTo;
    private boolean locked;
    private Items interactiveItem;
    private String actionString;

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

    public Exit(String description, Direction direction, Locations leadsTo, boolean locked, Items interactiveItem,String actionString) {
        this.description = description;
        this.direction = direction;
        this.leadsTo = leadsTo;
        this.locked = locked;
        this.actionString = actionString;
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
            if(actionString==null){

            }else {
                System.out.println(actionString);
            }
            if(this.locked=true){
                this.locked = false;
            }else if(this.locked=false){
                this.locked=true;
            }
        }
        return true;
    }
}
