package main.java.ui;

import jconsole.JConsole;

public class BlackjackGame {
	
	public static void main(String[] args) {
		
		// VARIABLES
		
		JConsole console = new JConsole(80, 20);
		SolitaryGame solitaryGame;
		
		int gameMode;

		
		// Messages
		String errorMessage = "No has elegido bien el numero";
		
		// Solitary game
		String playerNameMessage = "Elige tu nombre: ";
		String croupierNameMessage = "Elige el nombre de tu croupier: ";
		
		
		
		// Player's & croupier's names
		String croupierName;
		String playerName;
		
		
		
		// START GAME
		
		gameMode = getUserAnswer( console, "Bienvenido/s al blackjack... quieres jugar solo (pulsa 1) o con amigos (pulsa 2): ", errorMessage);
		
		if(gameMode == 1) {
			console.clear();
			
			playerName = getName(console, playerNameMessage);
			croupierName = getName(console, croupierNameMessage);
			
			console.clear();

			
			solitaryGame = new SolitaryGame(playerName, croupierName);
			solitaryGame.turnLoop( console );
			
		} else if( gameMode == 2) {
			
		}
		console.clear();
		gameMode = getUserAnswer(console, "Ya has experimentado una partida... te gustaría volver a jugar, dime si quieres jugar solo (pulsa 1) o con amigos (pulsa 2): ", errorMessage);
		
		
	}
	
	
	private static int getUserAnswer(JConsole console, String message, String errorMessage) {
		int answer;
		
		
		console.print(message);
		answer = console.readInt();
		
		while(answer <= 0 || answer >= 3) {
			
			console.println(errorMessage);
			
			console.print(message);
			answer = console.readInt();
		}
		
		return answer;
	}
	
	
	private static String getName(JConsole console, String message) {
		String name;
		
		console.print(message);
		
		name = console.readString();
		return name;
		
	}
	
	
}
