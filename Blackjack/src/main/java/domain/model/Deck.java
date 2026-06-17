package main.java.domain.model;

import java.util.Random;

import main.java.domain.exceptions.EmptyContainerException;
import main.java.domain.enums.Suits;
import main.java.domain.enums.Values;

public class Deck implements IContainer{

	// ATTRIBUTES
	private static final Suits suits[] = { Suits.CORAZONES, Suits.DIAMANTES, Suits.PICAS, Suits.TREBOLES };
	private static final Values values[] = { Values.AS, Values.DOS, Values.TRES, Values.CUATRO, Values.CINCO, Values.SEIS, Values.SIETE, Values.OCHO, Values.NUEVE, Values
			.DIEZ, Values.J, Values.Q, Values.K};
	private Card cards[][];
	
	// CONSTRUCTOR
	public Deck() {
		cards = new Card[suits.length][values.length];
		
		resetContainer();
	}
	
	
	// NOT MAKE THE ATTRIBUTE OF THE ARRAY OF "Cards" STATIC, BECAUSE IT'S POSSIBLE THAT WE WANT MORE THAN ONE CONTAINER OF CARDS
	// ALL THE FUNCTIONS ARE PUBLIC BUT NOT STATIC --> THIS CONTAINER FORMS PART OF THE BOARD, AND THIS ATTRIBUTE IS PUBLIC, IT'S LIKE THIS METHODS ARE ASO STATIC
	
	// ************
	// OTHER METHODS
	// ************
	
	/**
	 * Reset the container to the default value
	 */
	public void resetContainer() {

		for(int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				cards[i][j] = new Card(suits[i], values[j]);
			}
		}
	}

	/**
	 * Returns a random card of the container
	 * @return
	 */
	public Card getRandomCard(){
		Random alea = new Random();
		int suit, value;
		Card randomCard;
		
		// The container is empty
		if( isEmpty() ) {
			throw new EmptyContainerException("The container of cards is empty");
		}
		
		
		// Get a random position of the container of cards
		suit = alea.nextInt(0, suits.length);
		value = alea.nextInt(0, values.length);
		randomCard = cards[suit][value];
		
		// While the random position is already removed --> get another position
		while( randomCard == null ) {
			suit = alea.nextInt(0, suits.length);
			value = alea.nextInt(0, values.length);
			randomCard = cards[suit][value];
		} // The position of the container isn't null
		
		removeElement(cards[suit][value]); // Remove the element from the container (this card now form part of a user)
		
		return randomCard; // Get this randomCard
	}

	
	// METHODS OF THE "IContainer"

	@Override
	public void addElement(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Remove the object in the parameter, if object is not valid or is not on the container throw "IllegalArgumentException"
	 * @param obj
	 */
	public void removeElement(Object obj) {
		Card card;
		boolean found = false;
		
		// The object isn't a card
		if( !(obj instanceof Card) ) {
			throw new IllegalArgumentException("It's impossible to remove a card without a card, the object passed is: " + obj.toString());
		}
		card = (Card) obj; // The object is a card
			
		for(int i = 0; i < cards.length && !found; i++) {
			for (int j = 0; j < cards[i].length && !found; j++) {
				
				// The card isn't null
				if(cards[i][j] != null) {
					// The card is found (both if separated, because it cannot compare null objects)
					if( card.equals(cards[i][j])) {
						cards[i][j] = null;
						found = true;
					}
				}
				
			}
		}
		
		if(!found) throw new IllegalArgumentException("It's impossible to remove a card that isn't on the container: " + obj.toString());
		
	}


	@Override
	public IContainer getElement(int idx) {

		
		return null;
	}



	@Override
	/**
	 * Returns if the element is on the array, if the object is not valid (of the specified type) throw "IllegalArgumentException"
	 * @param obj
	 * @return
	 */
	public boolean isElement(Object obj) {
		Card card;
		
		// The object isn't a card
		if( !(obj instanceof Card) ) {
			throw new IllegalArgumentException("It's impossible to get a card with an object that isn't a card, the object passed is: " + obj.toString());
		}
		card = (Card) obj; // The object is a card
		
		for(int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; i++) {
				// A card is found
				if( card.equals(cards[i][j]) ) {
					return true;
				}
			}
		} // A card isn't found
		
		return false;
	}
	
	// Private methods?? --> Transformed to public (can be added to the interface)
	
	/**
	 * Check if the container is empty
	 * @return whether the conatiner is empty or not
	 */
	public boolean isEmpty() {
		
		for(int i = 0; i < cards.length; i++) {
			for(int j = 0; j < cards[0].length; j++) {
				// Find a filled position
				if( cards[i][j] != null ) {
					return false; // Container not empty
				}
			}
		}
		
		return true; // Container empty
		
	}
}
