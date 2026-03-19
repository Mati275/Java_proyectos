package enviroment;

import states.Suits;
import states.Values;


public class Card {
	
	// ATTRIBUTES
	private Suits suit;		// State of the suit of the card
	private Values value;	// State of the value of the card
	
	public static CardContainer cardContainer;
	
	
	// Static attributes
//	private static final String[] SUITS = {"CORAZONES", "DIAMANTES", "PICAS", "TREBOLES"};
//	private static final String[] VALUE = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "J", "K", "Q" };
	
	// CONSTRUCTOR(S)
	public Card( Suits suit, Values value ) {
		this.suit = suit;
		this.value = value;
	}
	
	// Constructor (generates a random card)
	public Card() {
		this( Suits.random(), Values.random() );
	}
	
	
	// GETTERS 
	public Suits getSuit () { return suit; }
	public Values getValue () { return value; }

	
	// SETTERS
	public void setSuit( Suits suit ) { this.suit = suit; };
	public void setValue( Values value ) { this.value = value; };

	
	
	// **********
	// OTHER METHODS
	// **********
	
	
//	public int getCardValue() {
//		
//		if( numValue >= 0 && numValue < 10 ) {
//			return numValue + 1;
//		}
//		else if ( numValue > 9 && numValue < 13 ) {
//			return 10;
//		}
//		
//		return -1; // El valor de la carta esta mal especificado --> Debería de ser imposible
//		
//	}

	
	@Override
	public String toString() {
		return value.getValue() + " de " + suit.getSuitName();
	}
	
}
