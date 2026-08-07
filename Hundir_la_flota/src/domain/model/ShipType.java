package domain.model;

import domain.exceptions.InvalidShipTypeException;

import java.util.HashSet;
import java.util.Set;

public class ShipType implements Comparable<ShipType>{

    // ATTRIBUTES
    private int height;
    private int width;
    private int size;

    private String name;
    private int id;         // The id is the "PK" that identifies one type of ship

    // int points;
    public static ShipType[] shipTypes; // All the shipTypes in the game

    // CONSTRUCTOR
    public ShipType(int height, int width, String name, int id){
        this.height = height;
        this.width = width;
        this.name = name;

        this.id = id;

        size = height * width;

        createShipTypes();
    }

    // GETTERS
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getSize() { return size; };
    public String getName() { return name; }

    public int getId() { return id; }

    // ************
    // OTHER METHODS
    // ************


    // PRIVATE METHODS

    /**
     * Creates the ShipTypes according to the parameters in the method and add the types to the "shipTypes" static attribute of the class
     * @param width
     * @param height
     * @param name
     * @param id
     * @throws InvalidShipTypeException if the length of the array in the parameters are different
     */
    private void createShipTypes(int[] width, int[] height, String[] name, int[] id ){

        Set<ShipType> uniqueShipTypes = new HashSet<>();

        int length = width.length; // Stablish the length of the width the reference length

        // Comparing if all the length are the same
        if( length == height.length && length == name.length && length == id.length ){

            for( int i = 0; i < length; i++){
                // Add a unique shipType
                // if the shipType is repeated --> Throw InvalidShipTypeException
                if ( !uniqueShipTypes.add( new ShipType( width[i], height[i], name[i], id[i] ) ) ){
                    throw new InvalidShipTypeException("You are trying to add 2 shipTypes that are the same; name: " + name[i] + " width: " + width[i] + "height: " + height[i] + "id: " + id[i]);
                }
            }
            // Transform the SET --> Array
            shipTypes = uniqueShipTypes.toArray(new ShipType[0]);

        } // The length aren't the same --> throw InvalidShipTypeException

        throw new InvalidShipTypeException("The method createShipTypes hasn't the right arrays according to it's lenght; width: " + width.length + " height: " + height.length + " name: " + name.length + " id: " + id.length);



    }

    /**
     * Creates by default 3 types of ships to make tests
     */
    private void createShipTypes(){

        int[] width = { 3, 4, 7 };
        int[] height = { 2, 2, 1 };
        String[] name = { "Small", "medium", "large" };
        int[] id = { 0, 1, 2 };

        createShipTypes(width, height, name, id);
    }

    // TODO: this method
    private void createRandomShips(int numOfTypes){

    }



    @Override
    public int compareTo(ShipType shipType) {
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

    @Override
    public int hashCode(){
        return id;
    }

}
