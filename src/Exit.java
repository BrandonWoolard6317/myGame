public class Exit {
    private String description;
    private Direction direction;
    private Locations leadsTo;

    public Exit(String description, Direction direction, Locations leadsTo) {
        this.description = description;
        this.direction = direction;
        this.leadsTo = leadsTo;
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
}
