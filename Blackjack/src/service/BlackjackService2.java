package service;

import domain.enums.CardValueState;
import domain.enums.GameState;
import domain.enums.RoundResultSolitary;
import domain.model.CroupierBeatable;
import domain.model.Deck;
import domain.model.Player;
import domain.model.User;

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


    /**
     * Starts the round, setting the current, adding one to the round and giving the initial cards to the player and croupier
     * @param bet
     * @return The number of the round
     */
    public int startRound(int bet) {
        bettingService.setBet(bet); // Set the current bet

        round++;
        deckService.giveInitialCards(player, croupier);

        return round;
    }

    /**
     * Called when there is an end condition
     * @return Who wins the round (a value of the enum "RoundResultSolitary")
     */
    public RoundResultSolitary endRound() {
        bettingService.resolveRound(player, croupier);

        deckService.resetContainer(); // Reset the deck
        return null;
    }

    public boolean isGameEnded(){

        player.isInBankruptcy();
        croupier.isInBankruptcy();

        return player.isInBankruptcy() || croupier.isInBankruptcy();
    }


    /**
     * Adds a card to the player
     * @return true if the player has less than 22 points, false if the player can't play another time in this round
     */
    public boolean playerHit() {
        player.addCard(deckService.getRandomCard());
        return player.getCardValueState() != CardValueState.NONE_CARD_VALUE;
    }

    /**
     * Adds a card to the croupier
     * @return true if the croupier has less than 22 points, false if the croupier can't play another time in this round
     */
    public boolean croupierHit() {
        croupier.addCard(deckService.getRandomCard());
        return croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE;
    }







}
