package java_14_05;

import java.util.Scanner; // importazione della libreria Scanner
// predendila la libreria Scanner, che si trova all'interno di java.util, e la rende disponibile nel programma

public class loop1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Scanner é una libraria
        // System é una libraria
	
		int numero = 0;
		
		while(numero <= 0) {
			System.out.print("Inserisci un numero maggiore di 0: ");
            // print stampa il testo senza andare a capo
            numero = input.nextInt(); 
            // si richiede all'utente di inserire un numero
            // nextInt() legge un intero da tastiera

		}

        System.out.println("hai inserito il numero: " + numero);



    }
    
}
