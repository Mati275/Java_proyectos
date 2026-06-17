package main.java.service;

import main.java.domain.model.Card;
import main.java.domain.model.CroupierBeatable;
import main.java.domain.model.Deck;
import main.java.domain.model.Player;

public class DeckService {

    // ATTRIBUTES
    private Deck deck;

    // CONSTRUCTOR

    public DeckService(){

        deck = new Deck();

    }

    // *******************
    // METHODS
    // *******************

    /**
     * Returns a random card of the deck
     * @return A random card that is contained in the deck
     */
    public Card getRandomCard(){
        return deck.getRandomCard();
    }

    /**
     * Gives the initial card to each user, depending on the numCards that is on 3rd param
     * @param player
     * @param croupier
     * @param numCards
     */
    public void giveInitialCards(Player player, CroupierBeatable croupier, int numCards){

        if( numCards > 0 ){
            for(int i = 0; i < numCards; i++){
                player.addCard(getRandomCard());
                croupier.addCard(getRandomCard());
            }
        } else{
            throw new IllegalArgumentException("The number of cards indicated to give initiali to the players is: " + numCards);
        }
    }

    /**
     * Gives the initial card to each user, 2 for the player, 2 for the croupier
     * @param player
     * @param croupier
     */
    public void giveInitialCards(Player player, CroupierBeatable croupier){
        giveInitialCards(player, croupier, 2);
    }


    /**
     *
     * @return if the deck is empty
     */
    public boolean isEmpty(){
        return deck.isEmpty();
    }


    /**
     * Reset the container to the default value
     */
    public void resetContainer(){
        deck.resetContainer();
    }



}
