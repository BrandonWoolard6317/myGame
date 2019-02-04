public class Exit {
    public enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    private String description;
    private DIRECTION direction;
    private Locations leadsTo;

    public Exit(String description, DIRECTION direction, Locations leadsTo) {
        this.description = description;
        this.direction = direction;
        this.leadsTo = leadsTo;
    }

    @Override
    public String toString() {
        String text = "Exit "
                + description + " that leads " +
                direction +
                " to " + leadsTo.getLocationName() +
                ". ";

        return text;
    }
}
