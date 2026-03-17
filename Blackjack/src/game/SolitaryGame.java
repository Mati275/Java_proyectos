package game;

import jconsole.JConsole;
import enviroment.*;
import states.*;

// Dentro de los "<>" esta el tipo de croupier que quiero que sea el croupier de esta partida, para especificarlo

// TODO: EN UN FUTURO HACER QUE EXTIENDA DE GAME
// ((Especializar los atributos de la superclase -> Pasan de ser mas genericas a mas especificas))

public class SolitaryGame {

	// ATTRIBUTES
	
	private Player player; // This variable is for having acces to the only player created in the array of players in the game
	private CroupierBeatable croupier;
	
	
	// CONSTRUCTOR
	public SolitaryGame() {
		super( 1 );
		
		this.croupier = new CroupierBeatable(); // Assign the croupier
		this.player = super.getPlayers()[0];  // Assign the player
	}
	
	
	// GETTERS
	public Player getPlayer() { return player; }
	
	
	// SETTERS
	public void setPlayer( Player player ) { this.player = player; }
	
	
	// **********
	// OTHER METHODS
	// **********
	
	
	@Override
	public void turnLoop(JConsole console) {
		
		char answer;
		int currentBet;
		boolean inTurnLoop = true;
		
		while(inTurnLoop) {
			
			printUsers(console);
			currentBet = getPlayerCurrentBet(console, player);
			player.setCurrentBet(currentBet);
			croupier.setCurrentBet(currentBet);
			
			console.println();
			
			croupier.addCard(2);
			player.addCard(2);
			
			// PRINT CROUPIER'S CARDS
			console.println("El croupier tiene: ");
			console.print(croupier.cardsToString());
			console.println(croupier.cardValueToString() + "\n");
			
			// PRINT PLAYER'S CARDS
			console.println("Tu tienes: ");
			console.print(player.cardsToString());
			console.println(player.cardValueToString() + "\n");
			
			answer = getPlayerAddOneCard( console );
			while( answer == 'Y' || answer == 'y' && player.getCardValueState() != CardValueState.NONE_CARD_VALUE) {
				
				// ADD ONE CARD TO THE PLAYER
				player.addCard();
				
				// PRINT PLAYER'S CARDS
				console.println("Tu tienes: ");
				console.print(player.cardsToString());
				console.println(player.cardValueToString());
				
				// When the card is added, the value is still valid, ask the player if they want to get another card
				if( player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
					answer = getPlayerAddOneCard( console );
				}	
			}
			
			while( croupier.addCard() && croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && croupier.getMaxCardValue() < player.getMaxCardValue() ) {
				// ADD ONE CARD TO THE CROUPIER
				
				
				// PRINT CROUPIER'S CARDS
				console.println("El croupier tiene: ");
				console.print(croupier.cardsToString());
				console.println(croupier.cardValueToString());
			}
			
			
			setChipsToEachPlayer(console);
			setChipsToTheCroupier(console);
			
			// TODO: HACERLO MAS OPTIMO
			croupier.removeAllCards();
			player.removeAllCards();
			
			hasGameEnded();
			
			if( gameState == GameState.ENDED ) {
				inTurnLoop = false;
			}
			
			console.println();
			
		}
		
		
		
	}
	
	@Override
	public boolean hasGameEnded() {
		if( croupier.getChips() <= 0 || player.getChips() <= 0 ) {
			gameState = GameState.ENDED;
			return true;
		}
		return false;
	}
	
	/**
	 * Set chips to the croupier, at the end of the round
	 * @param console
	 */
	public void setChipsToTheCroupier(JConsole console) {
		int croupierPoints = croupier.getMaxCardValue();
		int currentPlayerPoints = player.getMaxCardValue();
		
		// Remember: If the points are "-1" it means that the user passed 21 points
		
		// The croupier and the player haven't passed 21 points
		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
			if( currentPlayerPoints < croupierPoints ) {
				croupier.addChips( croupier.getCurrentBet() );
				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
			}
			else if( currentPlayerPoints == croupierPoints ) {
				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
			}
			else {
				croupier.addChips( -croupier.getCurrentBet() );
				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
			}
		}
		
		// The croupier passed 21 points
		else if( croupier.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
			croupier.addChips( -croupier.getCurrentBet() );
			console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
		}
		
		// The player passed 21 points
		else {
			croupier.addChips( croupier.getCurrentBet() );
			console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
		}
	}
	
	
	
	// EXTRA @OVERRIDE
	
	@Override
	public void printUsers(JConsole console) {
		
		console.println(croupier.toString()); 
		console.println(player.toString());
		
	}
	
	@Override
	public void setChipsToEachPlayer( JConsole console ) {
		int croupierPoints = croupier.getMaxCardValue();
		int currentPlayerPoints;
		

		
		currentPlayerPoints = player.getMaxCardValue();
		
		
		// The croupier and the player haven't passed 21 points
		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
			
			// Impossible to have "points <= 0"
			if( currentPlayerPoints < croupierPoints ) {
				player.addChips( -player.getCurrentBet() );
				console.println( "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)" );
			}
			else if( currentPlayerPoints == croupierPoints ) {
				console.println( "Jugador " + (1) + " ¡Has empatado! Ahora tienes " + player.getChips() + " ficha(s)" );
			}
			else {
				player.addChips( player.getCurrentBet() );
				console.println( "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)" );
			}
		
		} 
		
		// The player passed 21 points
		else if( player.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
			player.addChips( -player.getCurrentBet() );
			console.println( "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)" );
		}
		
		// The croupier passed 21 points
		else {
			player.addChips( player.getCurrentBet() );
			console.println( "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)" );
		}
	}
	
}
