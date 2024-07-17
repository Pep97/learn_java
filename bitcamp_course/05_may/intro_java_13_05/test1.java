package intro_java_13_05;

// Package é la sopra directory 

public class test1 {
	
	// class -> it's like a paper to work on
	// public -> indica che il file é visibile da qualsiasi file dentro il mio progetto
	
	public static void main(String[] args) {
		// static -> rende privato a classi esterne e ma accessibile all'interno della classe
		//void -> non ci torna in dietro nessun valore
		// main -> rende eseguibile un programma java, é una funzione.
		
		// to console your result you have to press F11
		
		// declare and start a type "int" variable
		
		int numeroIntero = 42;
				
		// declare and start a type "double" variable
		
		double numeroDecimale = 3.14;
				
		// declare and start a type "boolean" variable
		
		boolean valoreBooleano = true;
				
		// Color in Ecplise
		
		// blue -> it's the library
		// green -> it's the function
		// yellow -> the variable has never been used
		
		// -----------------------------------------
		
		// print 
		
		System.out.println("Il valore delle variable numeroIntero é: " + numeroIntero);
		System.out.println("Il valore delle variable numeroDecimale é: " + numeroDecimale);
		System.out.println("Il valore della variable valoreBooleano é: " + valoreBooleano);
		
		numeroIntero = 100; // assign a new value of the same data type 
		numeroDecimale = 2.5; 
		valoreBooleano = false; 
		
		System.out.println("Il nuovo valore delle variable numeroIntero é: " + numeroIntero);
		System.out.println("Il nuovo valore delle variable numeroDecimale é: " + numeroDecimale);
		System.out.println("Il nuovo valore della variable valoreBooleano é: " + valoreBooleano);
		
		
		
	}


}
