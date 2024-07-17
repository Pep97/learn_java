package java_14_05;

public class distributore_film_esercizio {

    // programma per distributore automatico 


    public static void main(String[] args) {
        
        // dichiarazione variabili

        int film_disponibili = 10;
        int film_in_prestito = 2;
        boolean tessera_valida = true;
        String titolo_film = "Pirati dei Caraibi";

        // operazioni matematiche

        int film_totali = film_disponibili + film_in_prestito;
        double prezzo_noleggio = 3.50 * 1.22; // prezzo in euro con iva al 22%

        // operazioni logiche e di confronto

        boolean disponibile = film_disponibili > 0;
        boolean in_prestito = film_in_prestito > 0;
        boolean abbonamento_pagato = tessera_valida == true;
        boolean film_richiesto = titolo_film.equals("Pirati dei Caraibi");
        // equals() confronta due stringhe e restituisce true se sono uguali
        // equalsIgnoreCase() confronta due stringhe ignorando le maiuscole e minuscole

        // costrutto condizionale

        if(disponibile && abbonamento_pagato){

            System.out.println("Puoi Noleggiare il film.");
        } else if (!disponibile){
            System.out.println("Spiacenti, Il film non é disponibile.");
        } else if (!abbonamento_pagato){
            System.out.println("Devi prima rinnovare la tessera.");
        }

        switch (titolo_film){
            case "Pirati dei Caraibi":
                System.out.println("Il film richiesto é Pirati dei Caraibi");
                break;
            case "Star Wars":
                System.out.println("Il film richiesto é Star Wars");
                break;
            default:
                System.out.println("Il film richiesto non é disponibile");
        }

        // stampa delle variabili ai fini di un log riepilogativo

        System.out.println("Film disponibili: " + film_disponibili);
        System.out.println("Film in prestito: " + film_in_prestito);
        System.out.println("Film totali: " + film_totali); 
        System.out.println("Prezzo noleggio: " + prezzo_noleggio);
        System.out.println("Il film é disponibile: " + disponibile);
        System.out.println("Abbonamento pagato: " + abbonamento_pagato);
        System.out.println("Il film richiesto é disponibile: " + film_richiesto);
        
    }
    
}
