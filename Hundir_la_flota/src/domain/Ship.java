package domain;

import states.ShipState;

public class Ship implements Comparable<Ship>{

    // ATTRIBUTTES

    // This position is a pivot
//    private int posX;
//    private int posY;
    Cell pivotCell;
    private ShipType shipType;
    private int remainingCells;

    private int id;             // The id is created automatically
    private static int nextId;

    // States
    private ShipState shipState;


    // CONSTRUCTOR

    /**
     * Creates a ship with a pivotCell, a shipType with a unique id, and it's shipState is "ALIVE"
     * @param pivotCell
     * @param shipType
     */
    public Ship (Cell pivotCell, ShipType shipType){

//        this.posX = posX;
//        this.posY = posY;

        // Assign all the attributes
        this.pivotCell = pivotCell;
        this.shipType = shipType;
        this.remainingCells = shipType.getSize();

        this.id = nextId;   // Assign the id to the correct value
        nextId ++;          // Prepare the next id for the next object

        shipState = ShipState.ALIVE;

    }



    // GETTERS

    // Attributes
    public Cell getPivotCell() {
        return pivotCell;
    }
    public ShipType getShipType() {
        return shipType;
    }
    public int getRemainingCells() {
        return remainingCells;
    }
    public ShipState getShipState() {
        return shipState;
    }
    public int getId() {
        return id;
    }

    // From shipType
    public int getShipTypeWidth() { return shipType.getWidth(); }
    public int getShipTypeHeight() { return shipType.getHeight(); }
    public int getShipTypeSize() { return shipType.getSize(); };
    public String getShipTypeName() { return shipType.getName(); }


    // ************
    // OTHER METHODS
    // ************


    /**
     *
     * @return if the ship is alive
     */
    public boolean isAlive(){
        return shipState == ShipState.DEATH;
    }


    /**
     * Change the number of cells depending on the quantity passed in parameters.
     * @param quantity
     * @return The remaining cells that this ship actually has
     * @throws IllegalArgumentException if the quantity of the remaining cells after the change is "< 0" or "> getShipTypeSize()"
     */
    public int changeRemainingCells( int quantity ){
        remainingCells += quantity;

        if(remainingCells < 0 || remainingCells > getShipTypeSize()){
            throw new IllegalArgumentException("The quantity of the ship: " + this.toString() + " is: " + remainingCells + " that is impossible.");
        }

        return remainingCells;
    }











    @Override
    public int compareTo(Ship ship) {
        return this.id - ship.id;
    }

    @Override
    public boolean equals(Object obj){
        Ship ship;

        if( !(obj instanceof Ship) ){
            throw new IllegalArgumentException("You are trying to compare a Ship with another type of object");
        }

        ship = (Ship) obj;

        return compareTo( ship ) == 0;

    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString(){
        return "Ship: id: " + id + " remainingCells: " + remainingCells + " size: " + getShipTypeSize() + " state: " + shipState;
    }

}
