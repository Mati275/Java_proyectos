package Player;

import Helper.*;

public class Player {
	
	private char character;
	private char character_enemy
	
	public Player(char character, char character_enemy) {
		this.character = character;
		this.character_enemy = character_enemy;
	}
	
	// Se puede hacer un movimiento en una posición en concreto?
	public boolean can_make_move_in_position(char[][] board, int idx_row, int idx_col) {
		if( Helper.get_if_filled_position( board, idx_row, idx_col ) == false ) {
			
			// Si arriba hay una ficha enemiga
			if(board [idx_row - 1][idx_col] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int row = idx_row - 1; row > 0; row --) {
					if(board [row][idx_col] == character) return true;
				}
			}
			
			// Si abajo hay una ficha enemiga
			if(board [idx_row + 1][idx_col] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int row = idx_row + 1; row < board.length; row ++) {
					if(board [row][idx_col] == character) return true;
				}
			}
			
			
			// Si a la derecha hay una ficha enemiga
			if(board [idx_row][idx_col + 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col + 1; col < board[idx_row].length; col ++) {
					if(board [idx_row][col] == character) return true;
				}
			}
			
			
			// Si a la izquierda hay una ficha enemiga
			if(board [idx_row][idx_col - 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col - 1; col > 0; col --) {
					if(board [idx_row][col] == character) return true;
				}
			}
			
			// Si en diagonal izquierda - arriba hay una ficha enemiga
			if(board [idx_row - 1][idx_col - 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col - 1, row = idx_row - 1; col > 0 && row > 0; col --, row --) {
					if(board [row][col] == character) return true;
				}
			}			
			
			// Si en diagonal derecha - arriba hay una ficha enemiga
			if(board [idx_row - 1][idx_col + 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col + 1, row = idx_row - 1; col < board[0].length && row > 0; col ++, row --) {
					if(board [row][col] == character) return true;
				}
			}	

			// Si en diagonal derecha - abajo hay una ficha enemiga
			if(board [idx_row + 1][idx_col + 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col + 1, row = idx_row + 1; col < board[0].length && row < board.length; col ++, row ++) {
					if(board [row][col] == character) return true;
				}
			}	
		
			// Si en diagonal izquierda - abajo hay una ficha enemiga
			if(board [idx_row + 1][idx_col - 1] == character_enemy) {
				// Recorro todo, si encuentro una pieza mia, me puedo mover
				for(int col = idx_col - 1, row = idx_row + 1; col > 0 && row < board.length; col --, row ++) {
					if(board [row][col] == character) return true;
				}
			}	
			
			
		}
		// Si en el sitio
		// 1. Esta lleno
		// 2. Estando vacio no hay ningun enemigo contiguo (diagonal incluido)
		// 3. Estando vacio y habiendo enemigo contiguo no hay ninguna ficha mia al otro lado
		return false;
	}
	
	// Se puede hacer un movimiento en todo el tablero?
	public boolean can_make_move(char[][] board) {
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[0].length; col ++) {
				if( can_make_move_in_position(board, row, col) ) return true;
			}
		}
		return false;
	}
	
	
	// Los cambios que hace (asumiendo que se ha comprobado y se puede hacer un movimiento en esa posición)
	public void make_move(char[][] board, int idx_row, int idx_col) {
		
		
		// Si arriba hay una ficha enemiga
		if(board [idx_row - 1][idx_col] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int row = idx_row - 1; row > 0; row --) {
				if(board [row][idx_col] == character) return true;
			}
		}
		
		// Si abajo hay una ficha enemiga
		if(board [idx_row + 1][idx_col] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int row = idx_row + 1; row < board.length; row ++) {
				if(board [row][idx_col] == character) return true;
			}
		}
		
		
		// Si a la derecha hay una ficha enemiga
		if(board [idx_row][idx_col + 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col + 1; col < board[idx_row].length; col ++) {
				if(board [idx_row][col] == character) return true;
			}
		}
		
		
		// Si a la izquierda hay una ficha enemiga
		if(board [idx_row][idx_col - 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col - 1; col > 0; col --) {
				if(board [idx_row][col] == character) return true;
			}
		}
		
		// Si en diagonal izquierda - arriba hay una ficha enemiga
		if(board [idx_row - 1][idx_col - 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col - 1, row = idx_row - 1; col > 0 && row > 0; col --, row --) {
				if(board [row][col] == character) return true;
			}
		}			
		
		// Si en diagonal derecha - arriba hay una ficha enemiga
		if(board [idx_row - 1][idx_col + 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col + 1, row = idx_row - 1; col < board[0].length && row > 0; col ++, row --) {
				if(board [row][col] == character) return true;
			}
		}	

		// Si en diagonal derecha - abajo hay una ficha enemiga
		if(board [idx_row + 1][idx_col + 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col + 1, row = idx_row + 1; col < board[0].length && row < board.length; col ++, row ++) {
				if(board [row][col] == character) return true;
			}
		}	
	
		// Si en diagonal izquierda - abajo hay una ficha enemiga
		if(board [idx_row + 1][idx_col - 1] == character_enemy) {
			// Recorro todo, si encuentro una pieza mia, me puedo mover
			for(int col = idx_col - 1, row = idx_row + 1; col > 0 && row < board.length; col --, row ++) {
				if(board [row][col] == character) return true;
			}
		}	
		
	}
	
}
