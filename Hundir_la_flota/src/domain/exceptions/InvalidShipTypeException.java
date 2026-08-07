package domain.exceptions;

public class InvalidShipTypeException extends RuntimeException{

    public InvalidShipTypeException(String msg){
        super(msg);
    }

}
