package domain.model;

public abstract class Cell {

    // ATTRIBUTES
    private boolean investigated;

    //private Ship ship;


    // CONSTRUCTOR
    public Cell(){

        this.investigated = false;  // At first, they aren't investigated

    }

    // GETTERS
    public boolean isInvestigated() {
        return investigated;
    }

    // SETTERS
    public void setInvestigated(boolean investigated) {
        this.investigated = investigated;
    }


    // **************
    // OTHER METHODS
    // **************


    /**
     *
     * @return if the cell can be investigated. True if it can be investigated, false if it cannot be investigated.
     */
    public boolean investigate() {

        if( investigated ){
            return false;
        }
        else{
            investigated = true;
            return true;
        }

    }



}
