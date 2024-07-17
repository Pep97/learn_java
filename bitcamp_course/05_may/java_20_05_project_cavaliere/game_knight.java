package java_20_05;

import java.util.Scanner;
import java.util.Random; // this library can generate different random data types and not only numbers


public class game_knight {

    // global variables (visible to all functions, not just main)

    // static means that the variable is public and accessible in the entire program

    static Scanner scanner = new Scanner(System.in); //  instance of the Scanner class
    static Random rand = new Random(); // instance of the Random class

    static int livelloGiocatore = 1;
    static int esperienzaGiocatore = 0;
    static int vitaGiocatore = 100;
    static int monete = 0;
    static String[] castello = {
        "                                  |>>>",
        "                                  |",
        "                    |>>>      _  |  _         |>>>",
        "                    |        |;| |;| |;|        |",
        "                _  |  _    \\\\.    .  /    _  |  _",
        "               |;||;||;|    \\\\:. ,  /    |;||;||;|",
        "               \\\\..      /    ||;   . |    \\\\.    .  /",
        "                \\\\.  ,  /     ||:  .  |     \\\\:  .  /",
        "                 ||:   |_   _ ||_ . _ | _   _||:   |",
        "                 ||:  .||||;||;||;||;|_|;||:.  |",
        "                 ||:   ||.    .     .      . ||:  .|",
        "                 ||: . || .     . .   .  ,   ||:   |       \\,/",
        "                 ||:   ||:  ,  ___   .   ||: , |            /`\\",
        "                 ||:   || .   /+++++++\\    . ||:   |",
        "                 ||:   ||.    |+++++++| .    ||: . |",
        "              _ ||: . ||: ,  |+++++++|.  . _||   |",
        "     __--~    '--~~__|.    |+++++__|----~    ~---,              ___",
        "---                   ---__|,--'                  ~----___-'   `----~"
    };

    // extra global variables

    static int classeAttacco = 1;
    static int classeDifesa = 1;





    
    public static void main(String[] args) {

        // main is a funciton (or method) that is called to run the program nothign else
        // functions are blocks of code that can be called multiple times and execute the code inside them

        // welcome message
        System.out.println("Benvenuto nel gioco di ruolo - Un Cavaliere all scorperta di Java!");
        System.out.println("\nUnisci all'avventura e carca di diventare il piú grande eroe!!");  // \n is a new line character

        while (vitaGiocatore > 0){

            // option menu

            for (String linea : castello) {
                System.out.println(linea);
            }
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Esplora");
            System.out.println("2. Riposa");
            System.out.println("3. Esci dal gioco");

            // read the user input

            int scelta = scanner.nextInt();

            // switch statement to handle the user input

            switch (scelta) {
                case 1:
                    esplora();
                    break;
                case 2:
                    riposa();
                    break;
                case 3:
                    System.out.println("Grazie per aver giocato! Arrivederci!");
                    System.exit(0); // exit the program
                    break;
            
                default:
                    System.out.println("Scelta non valida! Riprova!");
                    break;
            }

        }

        // game over message -> if the player has 0 health points and the while loop is not true anymore

        System.out.println("Hai perso! La tua avventura finisce qui!");

        
    }

    // create a new method (function) called esplora that will be called when the player chooses to explore

    // public is a keyword that means that the function is accessible from the entire program
    // static means that the function is not tied to a specific object instance
    // void means that the function does not return any value -> you just need to run the function and not get a value back
    

    public static void esplora(){

        // generate a random number between 1 and 100
        int probabilitaIncontro = rand.nextInt(100) + 1; 
        // the computer will generate numbers from 0 to 99, so we add 1 to get numbers from 1 to 100
        // 100 is the maximum value.

        // if conditional

        if(probabilitaIncontro <= 50){

            System.out.println("Esplorando la zona... Hai incontrato un mostro!");

            // call the fight function
            combatti();
        } else {
            int moneteTrova = rand.nextInt(10) + 1;
            System.out.println("Esplorando la zona... Hai trovato un tesoro " + moneteTrova + " monete!");
            monete += moneteTrova;
            System.out.println("Monete totali: " + monete);
        }
        
    }

    public static void combatti(){

        // generate a monster
        int vitaMostro = rand.nextInt(50) + 1;

        // second loop to manage the fight

        while(vitaMostro > 0 && vitaGiocatore > 0){
            
            // fight menu
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Attacca");
            System.out.println("2. Scappa");
            
            // take user input
            int scelta = scanner.nextInt();

            // switch statement to handle the user input

            switch (scelta) {
                case 1:
                    // attacca();
                    int dannoGiocatore = rand.nextInt(10) + 1;
                    int dannoMostro = rand.nextInt(10) + 1;

                    vitaMostro -= dannoGiocatore;
                    vitaGiocatore -= dannoMostro;

                    // feedback to the player

                    System.out.println("Hai inflitto " + dannoGiocatore + " danni al mostro!");
                    System.out.println("Il mostro ti ha inflitto " + dannoMostro + " danni!");
                    System.out.println("La tua vita: " + vitaGiocatore);
                    System.out.println("Vita del mostro: " + vitaMostro);
                    break;
                case 2:
                    System.out.println("Sei riuscito a scappare! la tua avventura continua...");
                    return; // exit the function;
            
                default:
                    System.out.println("Scelta non valida! Riprova!");
                    break;
            }

        }

        
        if (vitaGiocatore <= 0){
                System.out.println("Sei stato sconfitto dal mostro!");
                System.out.println("\nGAME OVER!");
                System.exit(0);
        }

        // if the player wins the fight

        System.out.println("Hai sconfitto il mostro! Continui la tua avventura...");

        // calculate the experience points and manage the level up

        int xpGuadagnati = rand.nextInt(20) + 10; // generate a random number between 10 and 30
        esperienzaGiocatore += xpGuadagnati;

        System.out.println("Hai guadagnato " + xpGuadagnati + " punti esperienza!");

        // check if the player levels up

        verificaLivelloSuccessivo();

    }

    public static void verificaLivelloSuccessivo(){

        // check if the player has enough experience points to level up

        int xpPerLivelloSuccessivo = livelloGiocatore*100;
        
        if(esperienzaGiocatore >= xpPerLivelloSuccessivo){

            // level up the player
            livelloGiocatore++;
            esperienzaGiocatore -= xpPerLivelloSuccessivo;

            // update player stats (max health, attack, defense, etc...)
            // this part is not implemented in this version of the game

            System.out.println("Complimenti! Sei salito al livello " + livelloGiocatore + "!");
        }

    }

    public static void riposa(){
            
            // define cost of resting
            int costoRecupero = 20;

            System.out.println("\nLa locanda per farti reposare richiede " + costoRecupero + " monete!");

            // check if the player has enough money to rest

            if (monete >= costoRecupero) {

                vitaGiocatore += 30;
                monete -= costoRecupero;
                System.out.println("Hai riposato e recuperato parte della vita.");
                System.out.println("La tua vita: " + vitaGiocatore);
                System.out.println("Monete rimanenti: " + monete);
                
            } else {
                System.out.println("Hai solo " + monete +", non hai abbastanza monete per riposare!");
            }

    }

}
