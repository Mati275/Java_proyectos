package main.java.domain.exceptions;

public class invalidMaxCardsException extends RuntimeException{
	
	public invalidMaxCardsException( String msg ) {
		super(msg);
	}
	
}
