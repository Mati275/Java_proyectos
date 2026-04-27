package ui;

import jconsole.JConsole;
import enviroment.*;
import states.*;

// Dentro de los "<>" esta el tipo de croupier que quiero que sea el croupier de esta partida, para especificarlo

// TODO: EN UN FUTURO HACER QUE EXTIENDA DE GAME
// ((Especializar los atributos de la superclase -> Pasan de ser mas genericas a mas especificas))

public class SolitaryGame {

	// ATTRIBUTES
	private BoardSolitaryGame board;
	private CardContainer cardContainer;
	
	// CONSTRUCTOR
	public SolitaryGame(String playerName, String croupierName) {
		board = new BoardSolitaryGame(playerName, croupierName);
		cardContainer = board.getCardContainer();
	}
	
	
	// GETTERS
	public BoardSolitaryGame getBoard() { return board; }
	
	
	// SETTERS
	public void setBoard( BoardSolitaryGame board) { this.board = board; }
	
	
	// **********
	// OTHER METHODS
	// **********
	
	
	/**
	 * Executes the turn loop in the game until the game ends (one of the players arrives to 0 chips)
	 * @param console
	 */
	public void turnLoop(JConsole console) {
		
		char answer;
		//int currentBet;
		boolean inTurnLoop = true;
		
		while(inTurnLoop) {
			
			cleanConsole(console);
			
			console.print( board.getUsersChips() );
			board.setCurrentBet(getPlayerCurrentBet(console, board.getPlayer()));
			//player.setCurrentBet(currentBet);
			//croupier.setCurrentBet(currentBet);
			
			console.println();
			
			// Croupier gets two cards
			board.getCroupier().addCard( cardContainer.getRandomCard() );
			board.getCroupier().addCard( cardContainer.getRandomCard() );
			
			// Player gets two cards
			board.getPlayer().addCard( cardContainer.getRandomCard() );
			board.getPlayer().addCard( cardContainer.getRandomCard() );

			
			// PRINT CROUPIER'S CARDS
			console.println(board.getCroupier().toString() + " ");
			console.print(board.getCroupier().cardsToString());
			console.println(board.getCroupier().cardValueToString() + "\n");
			
			// PRINT PLAYER'S CARDS
			console.println(board.getPlayer().toString() + " ");
			console.print( board.getPlayer().cardsToString() );
			console.println(board.getPlayer().cardValueToString() + "\n");
			
			// ASK PLAYER IF WANNA TAKE ONE CARD
			answer = getPlayerAddOneCard( console );
			while( answer == 'Y' || answer == 'y' && board.getPlayer().getCardValueState() != CardValueState.NONE_CARD_VALUE) {
				
				// ADD ONE CARD TO THE PLAYER
				board.getPlayer().addCard( cardContainer.getRandomCard() );
				
				// PRINT PLAYER'S CARDS
				console.println(board.getPlayer().toString() + " ");
				console.print(board.getPlayer().cardsToString());
				console.println(board.getPlayer().cardValueToString());
				console.println();
				
				// When the card is added, the value is still valid, ask the player if they want to get another card
				if( board.getPlayer().getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
					answer = getPlayerAddOneCard( console );
				}	
			}
			
			// GET A CARD OF THE CROUPIER UNTIL IT HASN'T SPACE IN IT'S DECK OR IT HAS MORE THAN 21 POINTS OR IT'S VALUE IT'S SUPERIOR THAN THE PLAYER
			while( !board.getCroupier().isCardsFull() && board.getCroupier().getCardValueState() != CardValueState.NONE_CARD_VALUE && board.getCroupier().getMaxCardValue() < board.getPlayer().getMaxCardValue() ) {
				// ADD ONE CARD TO THE CROUPIER
				
				// PRINT CROUPIER'S CARDS
				board.getCroupier().addCard( cardContainer.getRandomCard() );
				
				console.println(board.getCroupier().toString() + " ");
				console.print(board.getCroupier().cardsToString());
				console.println(board.getCroupier().cardValueToString());
				console.println();
			}
			
			
			console.println(board.getAndSetPlayerChips());
			console.println(board.getAndSetCroupierChips());
			
			// TODO: HACERLO MAS OPTIMO
			board.getCroupier().removeAllCards();
			board.getPlayer().removeAllCards();
			
			board.hasGameEnded();
			
			if( board.getGameState() == GameState.ENDED ) {
				inTurnLoop = false;
			}
			
			// Esperar a que el jugador presione una tecla para continuar
			console.print("Presiona una tecla para continuar: ");
			console.readChar();
						
		}
		
		console.println(board.getEndMessage());
		
		
		
	}
		
	
	/**
	 * Returns a correct value of the bet that the player in the parameter want to give
	 * @param console
	 * @param player
	 * @return
	 */
	public int getPlayerCurrentBet(JConsole console, Player player) {
		// Es correcto dejar un metodo que pida un valor al usuario sin una exepción, ya que no es responsabilidad de quien llama la función, sinó del usuario --> Error esperado
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
	
//	/**
//	 * Valid
//	 * @param bet
//	 * @param player
//	 * @return 
//	 */
//	public int validateBet(int bet, Player player) {
//		
//		if( bet < 1 || bet > player.getChips() ) {
//			throw new IllegalArgumentException("¡No puedes apostar ese valor!");
//		}
//		
//		return bet;
//	}
	
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
	
	
	
//	@Override
//	public boolean hasGameEnded() {
//		if( croupier.getChips() <= 0 || player.getChips() <= 0 ) {
//			gameState = GameState.ENDED;
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 * Set chips to the croupier, at the end of the round
//	 * @param console
//	 */
//	public void setChipsToTheCroupier(JConsole console) {
//		int croupierPoints = croupier.getMaxCardValue();
//		int currentPlayerPoints = player.getMaxCardValue();
//		
//		// Remember: If the points are "-1" it means that the user passed 21 points
//		
//		// The croupier and the player haven't passed 21 points
//		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
//			if( currentPlayerPoints < croupierPoints ) {
//				croupier.addChips( croupier.getCurrentBet() );
//				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
//			}
//			else if( currentPlayerPoints == croupierPoints ) {
//				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
//			}
//			else {
//				croupier.addChips( -croupier.getCurrentBet() );
//				console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
//			}
//		}
//		
//		// The croupier passed 21 points
//		else if( croupier.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
//			croupier.addChips( -croupier.getCurrentBet() );
//			console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
//		}
//		
//		// The player passed 21 points
//		else {
//			croupier.addChips( croupier.getCurrentBet() );
//			console.println( "El croupier tiene " + croupier.getChips() + " ficha(s)" );
//		}
//	}
//	
//	
//	
//	// EXTRA @OVERRIDE
//	
//	@Override
//	public void printUsers(JConsole console) {
//		
//		console.println(croupier.toString()); 
//		console.println(player.toString());
//		
//	}
//	
//	@Override
//	public void setChipsToEachPlayer( JConsole console ) {
//		int croupierPoints = croupier.getMaxCardValue();
//		int currentPlayerPoints;
//		
//
//		
//		currentPlayerPoints = player.getMaxCardValue();
//		
//		
//		// The croupier and the player haven't passed 21 points
//		if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
//			
//			// Impossible to have "points <= 0"
//			if( currentPlayerPoints < croupierPoints ) {
//				player.addChips( -player.getCurrentBet() );
//				console.println( "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)" );
//			}
//			else if( currentPlayerPoints == croupierPoints ) {
//				console.println( "Jugador " + (1) + " ¡Has empatado! Ahora tienes " + player.getChips() + " ficha(s)" );
//			}
//			else {
//				player.addChips( player.getCurrentBet() );
//				console.println( "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)" );
//			}
//		
//		} 
//		
//		// The player passed 21 points
//		else if( player.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
//			player.addChips( -player.getCurrentBet() );
//			console.println( "Jugador " + (1) + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)" );
//		}
//		
//		// The croupier passed 21 points
//		else {
//			player.addChips( player.getCurrentBet() );
//			console.println( "Jugador " + (1) + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)" );
//		}
//	}
	
	
	/**
	 * Cleans the console and put "BLACKJACK!" on the top of the console
	 * @param console
	 */
	private void cleanConsole(JConsole console) {
		String title = "BLACKJACK!";
		
		console.clear();
		for(int i = 0; i < title.length(); i++) console.print("*");
		
		console.print("\n" + title + "\n");
		
		for(int i = 0; i < title.length(); i++) console.print("*");
		
		console.println("\n");

	}
	
}
