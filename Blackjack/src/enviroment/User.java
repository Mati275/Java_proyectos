package enviroment;

import exceptions.invalidMaxCardsException;
// IMPORTS
import states.*;

public abstract class User {
	
	// ATTRIBUTES
	
	protected String name;
	
	protected Card cards[]; // Array of card that this specific user has
	protected int numCards; // Number of cards that the player has
	
	protected int cardValue; // Si el usuario saca un AS, el valor bajo se almacena aqui, si este valor > 21 --> No se tiene en cuenta
	protected int extraCardValue; // Si el usuario saca un AS, el valor alto se almacena aqui, si este valor > 21 --> No se tiene en cuenta
	
	protected CardValueState cardValueState; 
	protected UserState playingState; // Current state of the user
	
	protected static final int MAX_CARDS = 5;
	
	
	// STATES
	// playingState
//	protected static final int CAN_PLAY = 0;
//	protected static final int BANKRUPTCY = 1;
	
	// cardValueState
//	protected static final int CARD_VALUE = 0; // Se toma el valor mas pequeño (porque no ha tocado as o el otro valor de as se ha pasado de 21)
//	protected static final int EXTRA_CARD_VALUE = 1;  // Se toma el valor mas grande (oorque ha tocado as y no se ha pasado de 21)

	
	
	// CONSTRUCTOR
	public User( int max_cards, String name ) {
		
		if( max_cards <= 0 ) {
			throw new invalidMaxCardsException("It's not possible to add ");
		}
		
		cards = new Card[max_cards];		
		numCards = 0;
		
		this.name = name;
		
		playingState = UserState.PLAYING;
		cardValueState = CardValueState.NORMAL_CARD_VALUE;
		
	}
	
	public User( String name ) {
		this(MAX_CARDS, name);
	}
	
	
	// GETTERS
	public Card[] getCards() { return cards; }
	
	public String getName() { return name; }
	
	public int getNumCards() { return numCards; }
	
	public int getCardValue() { return cardValue; }
	public int getExtraCardValue() { return extraCardValue; }
	
	// states
	public CardValueState getCardValueState() { return cardValueState; }
	public UserState getPlayingState() { return playingState; }

	
	// SETTERS
	public void setNumCards( int numCards ) { this.numCards = numCards; }
	
	public void setName(String name) { this.name = name; }
	
	public void setCardValue( int cardValue ) { this.cardValue = cardValue; } 
	public void setExtraCardValue( int extraCardValue ) { this.extraCardValue = extraCardValue; } 

	
	// ***********
	// OTHER METHODS
	// ***********
	
	// Obtaining the maximum value that this User has in the moment
	public int getMaxCardValue() {
		switch ( cardValueState ) {
			case NORMAL_CARD_VALUE: return cardValue; 
			case EXTRA_CARD_VALUE: return extraCardValue;
			default: return -1;
		}
	}
	
	
	/** 
	 * Remove all the cards from the array of cards, and reset all the values related with the cards
	 */
	public void removeAllCards() {
		
		// Reset the value of the cards that this user has
		cardValue = 0;
		extraCardValue = 0;
		cardValueState = CardValueState.NORMAL_CARD_VALUE; // Reset the state of the card value
		
		for (int i = 0; i < numCards; i++) { cards[i] = null; }
		
		numCards = 0; // Reset the number of the cards that this user has
		
	}
	
	/** 
	 * Method that create (and assign) the number specified in the parameter of cards
	 * @param numCards (the number of cards to assign)
	 * @return boolean (if the card is added correctly return true, otherwise, false)
	 */
	
	public boolean addCard( Card randomCard ) {
		int randomCardValue;
		
		//if(numCards > 0) {
			//for(int i = 0; i < numCards; i++) {
				
				//randomCard = new Card(); // Create a random card
				randomCardValue = randomCard.getValue().getValue(); // Get the value of the card generated randomly
				
				// The card has a correct value && there is space on the array --> Assign the value and add it in the array
				if( randomCardValue >= 0 && !isCardsFull() ) {
					
					// Si la CARTA ES UN AS --> asigno un valor diferente para cada tipo de valor
					if( randomCardValue == 0 ) {
						this.cardValue += 1;
						extraCardValue += 11;
						// If the extraCardValue of the user < 22 --> is valid
						if( extraCardValue < 22 ) {
							cardValueState = CardValueState.EXTRA_CARD_VALUE;
						}
					}
					
					// Si la carta no es un as --> asigno un valor igual para cada tipo de valor
					else {
						this.cardValue += randomCardValue;
						extraCardValue += randomCardValue;
					}
					
					cards[this.numCards] = randomCard; // Añado la carta random
					this.numCards ++; // Increment the attribute of the number of cards by one
					
					// CONTROL DE ESTADOS
					
					// Si el valor extra es valido, pero despues de sacar una carta ya no lo es --> cambia de estado
					if( cardValueState == CardValueState.EXTRA_CARD_VALUE && extraCardValue > 21) {
						cardValueState = CardValueState.NORMAL_CARD_VALUE;
					}
					
					// Si el estado actual es el normal (despues de verificar el cambio de estado anterior), pero se ha pasado de 21 --> Cambia de estado
					if( cardValueState == CardValueState.NORMAL_CARD_VALUE && this.cardValue > 21) {
						cardValueState = CardValueState.NONE_CARD_VALUE;
					}
					
				} else {
					return false; // One card card hasn't a valid value or the array of cards is full
				}
				
			//}
			return true; // All the cards have a valid value 
		//} 
		
//		else {
//			throw new IllegalArgumentException("It's impossible to add " + numCards + " number(s) of card(s)"); // The value passed by parameter is 0 or negative
//		}
		
	}
	
	/** 
	 * Method that only creates and assign one card
	 * @return boolean (if the card is added correctly)
	 */
	public boolean addCard() {
		return addCard(1);
	}
	
	/** 
	 * Method that checks if the array of cards is full
	 * @return boolean (if the array of card is full)
	 */
	public boolean isCardsFull() {
		return numCards >= cards.length;
	}
	
	/** 
	 * Return an string that contains all the information about the cards that this user has
	 * @return String (the info about the user's cards)
	 */
	public String cardsToString() {
		String msg = "";
		
		for(int i = 0; i < numCards; i ++) {
			msg += cards[i].toString() + "\n";
		}
		
		return msg;
	}
	
	
	
	/** 
	 * Return an string that contains the information that the player must know about the total value of the cards of this user
	 * @return String (the tal value of this user's cards)
	 */
	public String cardValueToString() {
		if( cardValueState == CardValueState.NORMAL_CARD_VALUE ) return "Puntos: " + cardValue;
		else if( cardValueState == CardValueState.EXTRA_CARD_VALUE ) return "Puntos: " + cardValue + " / " + extraCardValue;
		else return "Puntos: Más de 21";
	}
	
	@Override
	/**
	 * Returns an string indicating who is this user
	 * @param
	 */
	public String toString() {
		return name;
	}
	
	
	/**
	 * Returns whether the user is in bankruptcy or not
	 * @return if this user is in bankruptcy
	 */
	public abstract boolean isInBankruptcy();
	
	
}
