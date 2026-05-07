package domain;

import exceptions.InvalidShipTypeException;

import java.util.HashSet;
import java.util.Set;

public class ShipType implements Comparable<ShipType>{

    // ATTRIBUTES
    private int height;
    private int width;
    private int size;

    private String name;

    // int points;

    public static ShipType[] shipTypes; // All the shipTypes in the game

    // CONSTRUCTOR
    public ShipType(int height, int width, String name){
        this.height = height;
        this.width = width;
        this.name = name;

        size = height * width;

        createShipTypes();
    }





    // ************
    // OTHER METHODS
    // ************


    // PRIVATE METHODS

    /**
     * Creates the ShipTypes according to the parameters in the method
     * @param width
     * @param height
     * @param name
     * @throws InvalidShipTypeException if the length of the array in the parameters are different
     */
    private void createShipTypes(int[] width, int[] height, String[] name){

        Set<ShipType> uniqueShipTypes = new HashSet<>();

        int length = width.length; // Stablish the length of the width the reference length

        // Comparing if all the length are the same
        if( length == height.length && length == name.length ){

            for( int i = 0; i < length; i++){
                // Add a unique shipType
                // if the shipType is repeated --> Throw InvalidShipTypeException
                if ( !uniqueShipTypes.add( new ShipType( width[i], height[i], name[i] ) ) ){
                    throw new InvalidShipTypeException("You are trying to add 2 shipTypes that are the same; name: " + name[i] + " width: " + width[i] + "height: " + height[i]);
                }
            }
            // Transform the SET --> Array
            shipTypes = (ShipType[]) uniqueShipTypes.toArray();

        } // The lenght aren't the same --> throw InvalidShipTypeException

        throw new InvalidShipTypeException("The method createShipTypes hasn't the right arrays according to it's lenght; width: " + width.length + " height: " + height.length + " name: " + name.length);



    }

    /**
     * Creates by default 3 types of ships to make tests
     */
    private void createShipTypes(){

        int[] width = { 3, 4, 7 };
        int[] height = { 2, 2, 1 };
        String[] name = { "Small", "medium", "large" };

        createShipTypes(width, height, name);
    }

    // TODO: this method
    private void createRandomShips(){

    }



    @Override
    public int compareTo(ShipType o) {
        return 0;
    }

}
