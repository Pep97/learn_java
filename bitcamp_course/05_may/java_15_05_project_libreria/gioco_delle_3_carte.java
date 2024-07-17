package java_15_05;

import java.util.Scanner;

public class gioco_delle_3_carte {
    
    public static void main(String[] args) {
        
        // istanza di scanner
        Scanner scanner = new Scanner(System.in);

        // dichiarazione delle variabili

        String[] carte = {"A", "B", "C"};
        int carta_scelta = -1; 
        // crea a variable to store the user's choice that has an invalid number
        int carta_vincente = (int)(Math.random() * 3);

        System.out.println("Benvenuto al gioco delle 3 carte");
        System.out.println();

        // main loop of the game

        while(true){

            // print cards
            System.out.println("Scegli una carta:");
            for(int i = 0; i < carte.length; i++) {
                System.out.println((i + 1) + ") " + carte[i]);
            }

            // take the user's choice
            carta_scelta = scanner.nextInt() -1;

            // check if the user's choice is carta_vincente

            if(carta_scelta == carta_vincente) {
                System.out.println("Complimenti hai vinto!!!");
                break; // stop the game
            } else {
                System.out.println("Spiacente, hai scelto la carta sbagliata!");
            }

        }



    }
    
}
