package domain;

public class Ship implements Comparable<Ship>{

    // ATTRIBUTTES
    private int posX;
    private int posY;

    private ShipType shipType;

    // CONSTRUCTOR
    public Ship (){

    }

    // GETTERS

    // ************
    // OTHER METHODS
    // ************

/*
    @Override
    public int compareTo(Ship o) {
        return this.id - shipType.id;
    }

    @Override
    public boolean equals(Object obj){
        ShipType shipType;

        if( !(obj instanceof ShipType) ){
            throw new IllegalArgumentException("You are trying to compare a ShipType with another type of object");
        }

        shipType = (ShipType) obj;

        return compareTo( shipType ) == 0;

    }

    public int hashCode(){
        return id;
    }
*/

}
