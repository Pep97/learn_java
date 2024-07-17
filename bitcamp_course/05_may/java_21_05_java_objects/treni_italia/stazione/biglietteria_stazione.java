package java_21_05_objects.treni_italia.stazione;

import java.util.Scanner;

public class biglietteria_stazione {
    
    public static void main(String[] args) {

        // istanze
        Scanner scanner = new Scanner(System.in);
        Biglietteria biglietteria = new Biglietteria();

        // loop principale del programma

        while(true){
            System.out.println("Benvenuto alla Biglietteria della stazione!");
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Acquista un biglietto");
            System.out.println("2. Visualizza i biglietti venduti");
            System.out.println("3. Uscire");
            
            // leggi input utente
            int scelta = scanner.nextInt();
            
            // elaborazione scelta utente 
            
            switch(scelta) {
            
            case 1:
                System.out.println("Inserisci la destinazione:");
                scanner.nextLine();  // fix bug
                String destinazione = scanner.nextLine();
                System.out.println("Inserisci il prezzo:");
                double prezzo = scanner.nextDouble();
                biglietteria.acquistaBiglietto(destinazione, prezzo);
            
                System.out.println("Biglietto acquistato!");
            
                break;
            case 2:
            	
            	System.out.println("Biglietti venduti");
            	biglietteria.visualizzaBiglietti();
            	break;
            	
            case 3:
            	
            	System.out.println("Grazie per aver usato la biglietteria della Stazione!");
            	return;
            	
            default:
            	
            	System.out.println("Scelta non valida!");
            	break;
            }
        }



    }


}

