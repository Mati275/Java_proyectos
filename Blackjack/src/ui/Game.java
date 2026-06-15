package ui;

import domain.model.Croupier;
import domain.model.Player;
import jconsole.JConsole;
import domain.enums.GameState;

public abstract class Game {
	
	// ATTRIBUTES
	
	// Atributos genericos que un juego contiene --> Luego en cada subclase se especializa con atributos propios
	private Croupier croupier; // TODO: VER SI ES NECESARIO O NO
	private Player[] players;
	private int numPlayers;
	
	// States
	protected GameState gameState; // El estado actual del juego 0: Se sigue jugando ; 1: Ya no se juega mas
	

	
	// CONSTRUCTOR 
	/**
	 * Creates a game
	 * @param numPlayers (the number of players that are going to play the game)
	 */
	public Game(int numPlayers) {
		
		//this.croupier = (C) croupier; // El croupier que se le pasa siempre es de tipo "C" (Si esta en una clase el tipo C va a ser el mismo que el tipo que se le pasa en el constructor)
		this.numPlayers = numPlayers;
		
		players = new Player[numPlayers]; // Se crea una array del tamaño de numero de jugadores que hay

		// Fill the array of players with the number of players
		for(int i = 0; i < numPlayers; i++) {
			players[i] = new Player(" ");
		}
		
		gameState = GameState.PLAYING; // Assign the value of the initial gameState
		
	}
	
	
	
	// GETTERS
	public Player[] getPlayers() { return players; }
	public Croupier getCroupier() { return croupier; }
	public GameState getGameState() { return gameState; }
	
	// SETTERS
	public void setCroupier( Croupier croupier ) { this.croupier = croupier; }
	public void setGameState( GameState gameState ) { this.gameState = gameState; }

	
	// **********
	// OTHER METHODS
	// **********
	
	/**
	 * Executes the loop of the turn until (at least) one user runs out of chips (end condition)
	 * @param console
	 */
	public abstract void turnLoop(JConsole console);
	
	
	/**
	 * Modifies the gameState if there's some end condition, called at the end of the turn loop
	 * @return boolean (return if the game has just ended)
	 */
	public abstract boolean hasGameEnded();
	
	
	// ASKING INFO. TO THE PLAYER
	
	/**
	 * Ask if the player want to get another card and get a valid answer character
	 * @param console
	 * @return char (return the character that the player inputs)
	 */
	public char getPlayerAddOneCard(JConsole console) {
		char answer;
		console.print("Quieres sacar otra carta? (Y/N) ");
		answer = console.readChar();
		
		while( answer != 'N' && answer != 'n' && answer != 'Y' && answer != 'y' ) {
			console.println("No has puesto un valor correcto :(");
			console.print("Quieres sacar otra carta? (Y/N) ");
			answer = console.readChar();
			
		}
		return answer;
		
	}
	 
	/**
	 * Returns a correct value of the bet that the player in the parameter want to give
	 * @param console
	 * @param player
	 * @return
	 */
	public int getPlayerCurrentBet(JConsole console, Player player) {
		int bet;
		console.print("¿Cuanto quieres apostar en esta ronda? ");
		bet = console.readInt();
		
		while( bet < 1 || bet > player.getChips() ) {
			console.println("¡No puedes apostar ese valor!");
			console.print("¿Cuanto quieres apostar en esta ronda ?");
			bet = console.readInt();
			
		}
		
		return bet;
	}
	
	/**
	 * Prints all the users in the game
	 * @param console
	 */
	public void printUsers( JConsole console ) {
		
//		console.println(croupier.toString()); 
//		
//		for (int i = 0; i < numPlayers; i ++) {
//			console.print(players[i].toString());
//		}
//		
	}
	
	/**
	 * Called when the round just ended and set the number of chips to each player, comparing their value with the croupier
	 * @param console
	 */
	public void setChipsToEachPlayer( JConsole console ) {
//		int croupierPoints = croupier.getMaxCardValue();
//		int currentPlayerPoints;
//		
//		for(int i = 0; i < numPlayers ; i++) {
//			
//			currentPlayerPoints = players[i].getMaxCardValue();
//			
//			if( currentPlayerPoints < croupierPoints ) {
//				players[i].addChips( -players[i].getCurrentBet() );
//				console.println( "Jugador" + (i + 1) + " Ohh has perdido esta ronda, ahora tienes " + players[i].getChips() + "ficha(s)" );
//			}
//			else if( currentPlayerPoints < croupierPoints ) {
//				console.println( "Jugador" + (i + 1) + " ¡Has empatado! Ahora tienes " + players[i].getChips() + "ficha(s)" );
//			}
//			else {
//				players[i].addChips( players[i].getCurrentBet() );
//				console.println( "Jugador" + (i + 1) + " Tomaa, has ganadooo :D, ahora tienes " + players[i].getChips() + "ficha(s)" );
//			}
//		}
		
	}
	
}
