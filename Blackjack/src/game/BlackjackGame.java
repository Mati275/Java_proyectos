package game;

import enviroment.*;
import jconsole.JConsole;

public class BlackjackGame {
	
	public static void main(String[] args) {
		
		// VARIABLES
		
		JConsole console = new JConsole(80, 20);
		SolitaryGame solitaryGame;
		
		String errorMessage = "No has elegido bien el numero";
		//CroupierBeatable croupier;

		int gameMode;
		
		// START GAME
		
		gameMode = getUserAnswer( console, "Bienvenido/s al blackjack... quieres jugar solo (pulsa 1) o con amigos (pulsa 2): ", errorMessage);
		
		if(gameMode == 1) {
			console.clear();
			solitaryGame = new SolitaryGame();
			solitaryGame.turnLoop( console );
		} else if( gameMode == 2) {
			
		}
		
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
	
}
