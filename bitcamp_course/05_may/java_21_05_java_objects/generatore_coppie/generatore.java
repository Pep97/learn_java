package java_21_05_objects.generatore_coppie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class generatore {


    public static void main(String[] args) {

        // istanze
        Scanner scanner = new Scanner(System.in);

        // variabili

        int scelta_menu = 0;

        // sei al punto dove:
        // 1. ti devi assicurare che contatore_elementi sia corretto e non ti calcola i null
        // 2. quando fai la stampa delle coppie, devi remuovere i null
        // 3. puoi continuare...


        // Gruppo[] gruppi = new Gruppo[10];
    
        // // Creazione array di stringhe
        // String[] elementi_esempio = new String[100];
        
        // elementi_esempio[0] = "Mario Rossi";
        // elementi_esempio[1] = "Luca Bianchi";
        // elementi_esempio[2] = "Paolo Verdi";
        // elementi_esempio[3] = "Giovanni Neri";
        // elementi_esempio[4] = "Giuseppe Gialli";
        // elementi_esempio[5] = "Andrea Blu";
        
        // // int contatore_index = 6;
        
        
        // // creazione gruppo d'esempio
        
        // gruppi[0] = new Gruppo("Gruppo d'esempio", elementi_esempio);
        
        // for (int i = 0; i < 1; i++) {
        //     System.out.println();
        //     gruppi[i].stampaInfo();
        // }


        // Inizio programma

        System.out.println("Benvenuto nel generatore di coppie random!");

        do{
            System.out.println("Come vuoi procedere?");
            System.out.println("1. Guarda un esempio del nostro generatore di coppie");
			System.out.println("2. Crea un gruppo");
			System.out.println("3. Visualizza tutti i gruppo");
			System.out.println("4. Esci dal programma");
            
            scelta_menu = scanner.nextInt();

            switch (scelta_menu) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:
                    
                        break;
                case 4:

                    System.out.println("Grazie per aver utilizzato il nostro generatore di coppie random!");
                    break;
                default:
                    System.out.println("Per favore, inseri un numero valido!");
                    break;
            }

        }while(scelta_menu!= 4);


        
        



        


        
    }
    
}
