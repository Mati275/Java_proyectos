package Helpers;

import java.util.Random;
import jconsole.JConsole;

// Si una variable es estatica, la función también tiene que serlo y viceversa (si no lo es la función no lo tiene que ser)

public class CartaRandom {
    
	public static String palo_carta[] = {"Corazones", "picas", "Treboles", "Diamentes" };
	public static String nombre_carta[] = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "J", "Q", "K"};
	static Random alea = new Random();
	
	// Atributos
	public String nombre;
    public String palo;
    public int valor;
    JConsole console;

    // Constructor (opcional, pero común) --> Al poner el mismo nombre a una función que el nombre de la clase solo hace falta poner public, es el metodo que se llama al asignar una variable a esta calse
    public CartaRandom( JConsole console ) {
        this.console = console; // asignar consola, lo primero de todo
    	this.nombre = get_random_nombre();
        this.palo = get_random_palo();
        this.valor = get_valor(this.nombre);
    }

    // Método
    
    
    public String get_random_nombre() {
		return(nombre_carta[alea.nextInt(0, 13)]);
	}
	
	public String get_random_palo() {
		return(palo_carta[alea.nextInt(0, 4)]);
	}
    
	public int get_valor(String nombre) {
		int valor = Helper.indexOf(nombre_carta, nombre);
		
		if ( valor == 0 ) {
			console.print("Te ha tocado un as, que valor quieres que tenga? (puede ser 1 o 11, elige ahora)");
			valor = console.readInt();
			
			while(valor != 1 && valor != 11) {
				console.print("Este NO es un valor correcto, dime un valor correcto: ");
				valor = console.readInt();
				console.println();
			}
			
			return valor;
		}
		else if ( valor < 10 ) {
			return valor + 1; // hasta el index 9 donde se encuentra el numero 10
		}
		else {
			return 10;
		}
		
		//return(nombre_carta.indexOf(nombre));
	}
	
    
    public void mostrar_carta() {
        console.println(nombre + " de " + palo + " tiene un valor de " + valor);
    }
}