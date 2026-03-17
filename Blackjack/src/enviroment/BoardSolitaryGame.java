package enviroment;

import states.CardValueState;
import states.GameState;

public class BoardSolitaryGame {

	// ATTRIBUTES
	// Users in game
	private Player player; 
	private CroupierBeatable croupier;
	
	private int round;
	
	private GameState gameState;
	
	// CONSTRUCTOR
	/**
	 * Initialize the attributes "player", "croupier", "round", "gameState"
	 */
	public BoardSolitaryGame() {
		
		player = new Player();
		croupier = new CroupierBeatable();

		round = 0;
		
		gameState = GameState.PLAYING;
	}
	
	// GETTERS
	public Player getPlayer() { return player; }
	public CroupierBeatable getCroupier() { return croupier; }
	public int getRound() {return round; }
	public GameState getGameState() { return gameState; }
	
	// SETTERS
	public void setPlayer( Player player ) { this.player = player; }
	public void setCroupier( CroupierBeatable croupier ) { this.croupier = croupier; }
	public void setRound( int round ) { this.round = round; }
	
	
	// ***************
	// OTHER METHODS
	// ***************

	/**
	 * Get all the users toString, meaning that returns an string of the number of chips of each user
	 * @return
	 */
	public String getUsersChips() {
		String msg = "";
		
		msg += croupier.toString() + "\n";
		msg += player.toString() + "\n";

		return msg;
	}
	
	/**
	 * Modifies the gameState if there's some end condition, called at the end of the turn loop
	 * @return boolean (return if the game has just ended)
	 */
	public boolean hasGameEnded() {
		if( croupier.getChips() <= 0 || player.getChips() <= 0 ) {
			gameState = GameState.ENDED;
			return true;
		}
		return false;
	}
	
	/**
	 * Set the chips to the croupier and get an string with the chips that the cropuier hasat the end of the round
	 * @return
	 */
	public String getAndSetCroupierChips() {
		String msg = "";
		
		int croupierPoints = croupier.getMaxCardValue();
		int currentPlayerPoints = player.getMaxCardValue();
		
		// Remember: If the points are "-1" it means that the user passed 21 points
		
		// The croupier and the player haven't passed 21 points
		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
			
			// The croupier has more points than the player
			if( currentPlayerPoints < croupierPoints ) {
				croupier.addChips( croupier.getCurrentBet() );
			}
			// The player has more points than the croupier
			else if( currentPlayerPoints > croupierPoints ) {
				croupier.addChips( -croupier.getCurrentBet() );
			}
			// Draw: Nothing
		}
		
		// The croupier passed 21 points
		else if( croupier.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
			croupier.addChips( -croupier.getCurrentBet() );
		}
		
		// The player passed 21 points
		else {
			croupier.addChips( croupier.getCurrentBet() );
		}
		
		// Add the message (the same for every situation)
		msg += "El croupier tiene " + croupier.getChips() + " ficha(s)";

		return msg;
	}
	
	
	/**
	 * Set the chips to the player and get an string with the chips that the player has at the end of the round
	 * The message received is also the information that the player has whether he won the round or not
	 * @return
	 */
	public String getAndSetPlayerChips() {
		String msg = "";
		
		int croupierPoints = croupier.getMaxCardValue();
		int currentPlayerPoints = player.getMaxCardValue();		
		
		// The croupier and the player haven't passed 21 points
		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
			
			// Impossible to have "points <= 0"
			if( currentPlayerPoints < croupierPoints ) {
				player.addChips( -player.getCurrentBet() );
				msg += "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
			}
			else if( currentPlayerPoints == croupierPoints ) {
				msg += "Jugador " + (1) + " ¡Has empatado! Ahora tienes " + player.getChips() + " ficha(s)";
			}
			else {
				player.addChips( player.getCurrentBet() );
				msg += "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
			}
		
		} 
		
		// The player passed 21 points
		else if( player.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
			player.addChips( -player.getCurrentBet() );
			msg += "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
		}
		
		// The croupier passed 21 points
		else {
			player.addChips( player.getCurrentBet() );
			msg += "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
		}
		
		return msg;
	}
	
}
