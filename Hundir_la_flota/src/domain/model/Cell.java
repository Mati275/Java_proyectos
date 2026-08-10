package domain.model;

import domain.enums.CellState;

public class Cell {

    // ATTRIBUTES
    private Ship ship;
    private CellState cellState;
    private boolean investigated;

    // CONSTRUCTOR
    public Cell(){

        this.cellState = CellState.VOID;
        this.investigated = false;

    }

    // GETTERS

    public CellState getCellSate() {
        return cellState;
    }




    // **************
    // OTHER METHODS
    // **************

    /**
     * Change the state of the cell to filled (has a ship) only if the cell's state previously was CellState.VOID
     * @throws RuntimeException
     */


    public void setCellFilled(){

        if( ! (cellState == CellState.VOID) ) {
            throw new RuntimeException("The cell: " + this.toString() + " that you are trying to fill is already filled");
        }
        cellState = CellState.FILLED;

    }

    public boolean investigate(){
        if(!investigated){

            if( cellState == CellState.FILLED )

        }
    }




}
