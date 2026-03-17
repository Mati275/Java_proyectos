package Othello;

import Helper.*;
import Player.*;
import jconsole.JConsole;

public class Othello {

	
	public static void main(String[] args ) {
		
		int players;
		char[][] board = new char[8][8];
		Player player1 = new Player('B', 'W');
		Player player2 = new Player('W', 'B');
		JConsole console = new JConsole(80, 40);
		
		
		players = Helper.get_int(console, 1, 2, "Give me the numbers of players (1, if you play alone; 2, if you play with a friend)");
		
		
	}
	
}
