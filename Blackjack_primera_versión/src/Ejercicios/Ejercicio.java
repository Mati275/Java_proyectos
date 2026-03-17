package Ejercicios;

import jconsole.JConsole;

public class Ejercicio {
	
	public static void main (String [] Args) {
		
		JConsole console = new JConsole(80, 20);
		
//		int numero;
//		int fila;
//		int asteriscos_actuales, blancos_actuales, caracteres_totales;
//		
//		console.print("Dime un número!!");
//		numero = console.readInt();
//		
//		caracteres_totales = (numero * 2) -1;
//		fila = 1;
//		
//		console.println();
//		
//		while ( fila <= numero ) {
//			
//			asteriscos_actuales = (fila * 2) -1;
//			blancos_actuales = caracteres_totales - asteriscos_actuales;
//			
//			int counter = 1;
//			
//			while( counter <= blancos_actuales / 2) {
//				console.print(" ");
//				counter ++;
//			}
//			
//			counter = 1;
//			while ( counter <= asteriscos_actuales ) {
//				console.print("*");
//				counter ++;
//			}
//			
//			counter = 1;
//			while( counter <= blancos_actuales / 2) {
//				console.print(" ");
//				counter ++;
//			}
//			
//			console.println();
//			fila ++;
//			
//		}
		
		//console.print("hola".compareTo("holaayhg"));
		

		
		
		
		
		
		
		
		console.setCursorPosition(0, console.getRows() - 1);
		console.print("Pulsa qualquier tecla para salir");
		console.readKey(); 
		System.exit(0);
		
	}
	
	public static void holis(String caracter, int veces, JConsole console) {
		for (int i = 0; i<veces; i++) {
			console.print(caracter);
		}
		
	}
}
