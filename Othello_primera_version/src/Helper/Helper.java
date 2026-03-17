package Helper;

import jconsole.JConsole;

public class Helper {

	// Escribe un caracter "x" veces, preguntando si se quiere salto de linea o no al final
	// Llamando a los 4 parámetros
	public static void write_character(JConsole console, String character, int times, boolean jump_line) {
		
		for(int i = 0; i < times; i++) {
			console.print(character);
		}
		if(jump_line) console.println();
	}
	
	// Llamando a 3 parámetros se asigna uno por defecto
	public static void write_character(JConsole console, String character, int times) {
		write_character(console, character, times, false);
	}
	
	
	// Obtiene un valor int del teclado entre un minimo y maximo
	public static int get_int(JConsole console, int min, int max, String message) {
		int value;
		
		console.print(message);
		value = console.readInt();
		
		while( value < min || value > max ) {
			console.println("This is not a correct value");
			console.print(message);
			value = console.readInt();
		}
		
		return value;
		
	}
	
	
	
	
	

	
	public static void title(JConsole console) {
		String title = "OTHELLO!";
		
		write_character(console, "*", title.length(), true); 
		console.println(title);
		write_character(console, title, title.length(), true);
		
	}
	
	public static void rules(JConsole console) {
		
		console.print("");
		console.setCursorPosition(0, console.getRows() - 1);
		console.print("Press any key to start... Good luck");
	}

	
	// ****************
	// BOARD
	// ***************
	
	public static boolean get_if_filled_position(char[][] board, int idx_row, int idx_col) {
		if (board [idx_row][idx_col] == 'v') return false;
		else return true;
	}
	
	public static void fill_center(char[][] board) {
		board[board.length / 2 - 1][board.length / 2 - 1] = 'W';
		board[board.length / 2 - 1][board.length / 2] = 'B';
		board[board.length / 2][board.length / 2 - 1] = 'W';
		board[board.length / 2][board.length / 2] = 'B';
	}
	
	public static void fill_board(char[][] board) {
		
		for (int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col ++) {
				board[row][col] = 'v';
			}
		}
		fill_center(board);
		
	}
	
	
	public static void show_board(JConsole console, char[][] board) {
		for (int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col ++) {
				console.print(board[row][col] + " "); 
			}
			console.println();
		}
	}
	
	
	
}
