package Blackjack;

import java.awt.Color;
import java.util.Random;
import jconsole.JConsole;
import Helpers.*;
public class Blackjack {

	static int fichas_banca = 100;
	static int fichas_jugador = 100;
	static int fichas_apostadas;
	
	
	//static int num_banca_tirada, num_jugador_tirada;
	static CartaRandom carta;
	
	static int num_jugada_banca = 0;
	static int num_jugada_jugador = 0;
	
	static Random alea = new Random();

	
	
	// JUEGA JUGADOR
	public static void juega_jugador(JConsole console) {
		char tecla;
		boolean still_playing = true;
		
		while(still_playing) {
			
			// Saca una carta
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_jugador += carta.valor;
			
			
			// Enseña la puntuación
			console.println( "Tienes: " + num_jugada_jugador);
			
			// Si el jugador no se pasa de las fichas
			if (num_jugada_jugador <= 21) {
				console.print("Sigues o te plantas? (pulsa s o S para seguir y cualquier otra para plantarte): ");
				tecla = console.readChar();
				
				// El jugador decide rendirse, sino vuelve a comenzar el bucle
				if ( tecla != 's' &&  tecla != 'S') { // El jugador no toca 's' ni 'S'
					still_playing = false;
					juega_banca( console );
				}
				
			}
			
			// Si el jugador se pasa de las fichas
			else{
				still_playing = false;
				ronda_se_pasan_de_fichas( console );
			}
			
		}
	}
	
	// JUEGA BANCA
	public static void juega_banca(JConsole console) {
		boolean still_playing = true;
		
		while(still_playing) {
			
			// Saca carta
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_banca += carta.valor;
			
			// Muestra puntos
			console.println( "La banca tiene: " + num_jugada_banca);
			
			// Si la banca no se pasa de fichas revisa si tiene mas, las mismas fichas o menos fichas que el jugador
			
			// Si la banca no ha perdido
			if (num_jugada_banca <= 21) {
				
				// Si la banca tiene el mismo numero o mas grande que el jugador (luego hacer que si tenga el mismo numero que haya una posibilidad que vuelva a jugar)
				if ( num_jugada_banca >= num_jugada_jugador) {
					still_playing = false;
					ronda_no_se_pasan_de_fichas( console );
				}
				
			}
			
			// Si la banca se pasa de fichas se acaba la ronda
			else{
				still_playing = false;
				ronda_se_pasan_de_fichas( console );
			}
			
		}
		
		
	}
	
	public static void mostrar_fichas(int fichas_banca, int fichas_jugador, JConsole console) {
		console.println("La banca tiene estas fichas: " + fichas_banca);
		console.println("Tu tienes estas fichas: " + fichas_jugador);
	}
	
	// ******************
	// PILLAR UN VALOR
	// ******************
	
	public static int get_fichas_apostadas_correctas( int fichas, JConsole console) {
		int value;
		value = console.readInt();
		
		while (value > fichas) {
			console.setForegroundColor(Color.red);
			console.print("Pero que dices tio, si no tienes tantas fichas loco, venga, dime un numero correcto: ");
			
			console.setForegroundColor(Color.cyan);
			value = console.readInt();
		}
		console.resetColor();
		
		return value;
	}
	

	// ******************
	// Acabar la ronda
	// ******************
	
	public static void ronda_se_pasan_de_fichas(JConsole console) {
		
		// Gana banca
		if(num_jugada_jugador > 21 && num_jugada_banca <= 21) {
			
			fichas_banca += fichas_apostadas;
			fichas_jugador -= fichas_apostadas;
			
			console.println("Esta ronda la ha ganado la banca ;'(, tu puedes!");
			console.println("");
			console.println("");

			
		}
		
		// Gana jugador
		else if ( num_jugada_banca > 21 && num_jugada_jugador <= 21) {
			
			fichas_banca -= fichas_apostadas;
			fichas_jugador += fichas_apostadas;
			
			console.println("Esta ronda la has ganado! Felicidades!");
			console.println("");
			console.println("");
			
		}
		
		// Empate --> Creo que imposible
		else if ( num_jugada_banca > 21 && num_jugada_jugador > 21 ) {
			
			console.println("Ups, os habeis pasado los dos, las fichas se mantienen como antes");
			console.println("");
			console.println("");
			
		}
	}
	
	public static void ronda_no_se_pasan_de_fichas(JConsole console) {
		
		//Gana banca
		if(num_jugada_jugador < num_jugada_banca) {
			
			fichas_banca += fichas_apostadas;
			fichas_jugador -= fichas_apostadas;
			
			console.println("Esta ronda la ha ganado la banca ;'(, tu puedes!");
			console.println("");
			console.println("");
			
		}
		
		// Gana jugador
		else if ( num_jugada_jugador > num_jugada_banca) {
			
			fichas_banca -= fichas_apostadas;
			fichas_jugador += fichas_apostadas;
			
			console.println("Esta ronda la has ganado! Felicidades!");
			console.println("");
			console.println("");
		}
		
		// Empate
		else if ( num_jugada_jugador == num_jugada_banca ) {
			
			console.println("Ups, habeis empatado ;), las fichas se mantienen como antes");
			console.println("");
			console.println("");
			
		}
	}	

	
	// ********
	// MAIN
	// *********
	
	public static void main (String [] Args) {
		
		char tecla;
		
		JConsole console = new JConsole(100, 40);
		
		console.println("********************");
		console.println("BLACKJACK!");
		console.println("********************");
		
		while (fichas_banca > 0 && fichas_jugador > 0) {
			
			// Reinicia los puntos 
			num_jugada_jugador = 0;
			num_jugada_banca = 0;
			
			mostrar_fichas(fichas_banca, fichas_jugador, console);
			
			
			console.print("Cuantas fichas quieres apostar? ");
			fichas_apostadas = get_fichas_apostadas_correctas(fichas_jugador, console);
			console.println();
				
			/*
			 * PRIMERA TIRADA
			 */
			
			
			// CARTAS DEL JUGADOR
			console.println("Tus cartas són:");
			
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_jugador += carta.valor;
			
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_jugador += carta.valor;
			console.println();
			
			//CARTAS DE LA BANCA
			console.println("Las cartas de la banca són:");
			
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_banca += carta.valor;
			
			carta = new CartaRandom(console);
			carta.mostrar_carta();
			num_jugada_banca += carta.valor;
				
				
			console.println("");
			console.println("Tienes: " + num_jugada_jugador);
			console.println("La banca tiene: " + num_jugada_banca);
			
			console.println("");
			
				
				/*
				 * PREGUNTA POR UNA SEGUNDA TIRADA
				 */
				
				// La gracia es pulsar p para plantarse, ya vere que hago
				console.print("Sigues o te plantas? (pulsa s o S para seguir y cualquier otra para plantarte): ");
				tecla = console.readChar();

				// El jugador decide hacer una segunda tirada
				if (tecla == 's' || tecla == 'S') {
					juega_jugador( console );
				}
				
				// El jugador no decide hacer una segunda tirada
				else {
					juega_banca( console );
				}
				
			} // Se acaban las fichas de algun jugador
				
			
		// PIERDE ALGUN JUGADOR
		if ( fichas_jugador > fichas_banca ) {
			console.println("felicidades! Has ganado :D No tendras tanta suerte la proxima vez...");
		}
		else {
			console.println("Ohh perdiste :( Espero que vuelvas la proxima vez cargadito de emoción...");
		}
			
		console.setCursorPosition(0, console.getRows() - 1);
		console.setForegroundColor(Color.yellow);
		console.print("Pulsa qualquier tecla para salir del casino... Te veré muy muy pronto");
		System.exit(0);
	}
}	



