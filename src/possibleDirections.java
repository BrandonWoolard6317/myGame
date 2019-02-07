public class possibleDirections {
    private Direction direction1,direction2,direction3,direction4;
    private String directionAll;

    public possibleDirections(Direction direction1) {
        this(direction1,direction1);
    }

    public possibleDirections(Direction direction1, Direction direction2) {
        this(direction1,direction2,direction1);
    }

    public possibleDirections(Direction direction1, Direction direction2, Direction direction3) {
        this(direction1,direction2,direction3,direction1);
    }

    public possibleDirections(Direction direction1, Direction direction2, Direction direction3, Direction direction4){
        this.direction1 = direction1;
        this.direction2 = direction2;
        this.direction3 = direction3;
        this.direction4 = direction4;
        collectDirections();
    }

    @Override
    public String toString() {
        return "-----------------------------------------\n"+
                "        All Possible Directions"+
                "\n-----------------------------------------\n"+
                "           "+directionAll+
                "\n-----------------------------------------\n";
    }

    public void changePossibleDirections(Direction direction1, Direction direction2, Direction direction3, Direction direction4){
        this.direction1 = direction1;
        this.direction2 = direction2;
        this.direction3 = direction3;
        this.direction4 = direction4;
        collectDirections();
    }





    private void collectDirections(){
        if(direction2==direction1){
            directionAll = ""+direction1;
        }else if(direction3==direction1){
            directionAll = direction1+" "+direction2;
        }else if(direction4==direction1){
            directionAll = direction1+" "+direction2+" "+direction3;
        }else{
            directionAll = direction1+" "+direction2+" "+direction3+" "+direction4;
        }
    }

    public Direction getDirection1(){return direction1;}

    public Direction getDirection2(){return direction2;}

    public Direction getDirection3(){return direction3;}

    public Direction getDirection4(){return direction4;}

    public String listDirections(){
        return directionAll;
    }
}
