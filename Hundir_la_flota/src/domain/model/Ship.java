package domain.model;

import domain.enums.ShipState;

public class Ship implements Comparable<Ship>{

    // ATTRIBUTTES

    Cell pivotCell;
    private ShipType shipType;

    private int remainingCells;
    private int remainingBullets;

    // The id is created automatically
    private int id;
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
        this.remainingBullets = shipType.getInitialBullets();

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
    public int getShipTypeReloadBullets() { return shipType.getReloadBullets(); }


    // ************
    // OTHER METHODS
    // ************

    /**
     *
     * @return if the ship can shoot
     */
    public boolean shoot(){

        // The ship can shoot
        if(remainingBullets > 0) {
            remainingBullets -= 1;
            return true;
        } // The ship can't shoot

        return false;
    }


    /**
     * Subtract the number of cells depending on the quantity passed in parameters.
     * @param quantity
     * @return The remaining cells that this ship actually has
     * @throws IllegalArgumentException if the quantity of the remaining cells after the change is "< 0" or "> getShipTypeSize()"
     */
    public int hurt( int quantity ){

        if(quantity <= 0){
            throw new IllegalArgumentException("The quantity of cells to substract is negative or 0: " + quantity);
        }

        remainingCells -= quantity;

        // The quantity is impossible to subtract (it remains negative cells)
        if(remainingCells < 0 || remainingCells > getShipTypeSize()){
            throw new IllegalArgumentException("The quantity of the ship: " + this.toString() + " is: " + remainingCells + " that is impossible.");
        } // The quantity is possible to subtract

        return remainingCells;
    }




    /**
     *
     * @return if the ship is alive
     */
    public boolean isAlive(){
        return shipState == ShipState.DEATH;
    }



    // TODO
    /*
    public String shipInfo(){
        return null;
    }
    */




    /* TODO Future method ?
    public int repair(){
        return 0;
    } */


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
