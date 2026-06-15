package service;

import domain.enums.CardValueState;
import domain.enums.GameState;
import domain.model.CroupierBeatable;
import domain.model.Deck;
import domain.model.Player;

public class BlackjackService2 {

    // ATTRIBUTES

    private Player player;
    private CroupierBeatable croupier;

    private int round;
    //private int currentBet;
    private GameState gameState;

    private DeckService deckService;
    private BettingService bettingService;

    /**
     * Initialize the attributes "player", "croupier", "round", "gameState" + cardService, bettingService
     * @param playerName
     * @param croupierName
     */
    public BlackjackService2(String playerName, String croupierName) {

        player = new Player(playerName);
        croupier = new CroupierBeatable(croupierName);

        deckService = new DeckService();
        bettingService = new BettingService();

        //cardContainer = new CardContainer();

        round = 0;

        gameState = GameState.PLAYING;
    }


    // GETTERS
    public Player getPlayer() { return player; }
    public CroupierBeatable getCroupier() { return croupier; }
    public int getRound() {return round; }
    public int getCurrentBet() {return currentBet; }
    public GameState getGameState() { return gameState; }

    // SETTERS
    public void setPlayer( Player player ) { this.player = player; }
    public void setCroupier( CroupierBeatable croupier ) { this.croupier = croupier; }
    public void setRound( int round ) { this.round = round; }
    public void setCurrentBet( int currentBet ) { this.currentBet = currentBet; }



    public void startRound(int bet) {
        bettingService.setBet(bet); // Set the current bet

        round++;
        deckService.giveInitialCards(player, croupier);
    }


    /**
     * Called when there is an end condition
     */
    public void endRound() {
        bettingService.resolveRound(player, croupier);
        deckService.resetContainer(); // Reset the deck
    }

    /**
     * Adds a card to the player
     * @return true if the player has less than 22 points, false if the player can't play
     */
    public boolean playerHit() {
        player.addCard(deckService.getRandomCard());
        return player.getCardValueState() != CardValueState.NONE_CARD_VALUE;
    }

    /**
     * Adds a card to the croupier
     * @return true if the croupier has less than 22 points, false if the croupier can't play
     */
    public boolean croupierHit() {
        croupier.addCard(deckService.getRandomCard());
        return croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE;
    }







}
