package java_14_05;

import java.util.Scanner;

public class loop3 {

    public static void main(String[] args) {
		
		// indovina il numero -> se il numero é vicino bisogna dirmi se il numero é maggiore o minore
        // crea cicle che si deve ripere per prende un valore e controllare
		
		
		Scanner input = new Scanner(System.in);
		
		int numero_vincente = 42;
		int scelta;
        int contatore = 0;

        System.out.println("Benvenuto al gioco Indovina il numero!! Divertiti con noi!!");
        System.out.println();
		
		do {

            contatore++;
			System.out.println("Indovina il numero (compreso tra 1 e 100)");
			scelta = input.nextInt();
			
			if( scelta < numero_vincente) {
				System.out.println("Il numero da indovinare é maggiore");
			} else if (scelta > numero_vincente) {
				System.out.println("Il numero da indovinare é minore");
			}
			
		} while(scelta != numero_vincente);

        System.out.println("Complimenti hai indovinato il numero in " + contatore + " tentativi");
		
	}

}
