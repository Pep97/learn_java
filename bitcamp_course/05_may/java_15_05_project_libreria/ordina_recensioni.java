package java_15_05;

import java.util.Scanner;

public class ordina_recensioni {
    
    	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int scelta;
		String autore;
		String libro;
		String anno;
		String genere;
		String copie;
		String ricerca;
		String recensione;
		String firma;
		String valutazione;
		int grandezzaLibreria = 6;
		int numero;
		int indiceRecensione;
		int media;
		//Dichiarazione Array
		String[][] libreria = new String[10][6];


        libreria[0][0] = "Harry Potter e il calice di fuoco";
        libreria[0][1] = "J.K. Rowling";
        libreria[0][2] = "2001";
        libreria[0][3] = "Fantasy";
        libreria[0][4] = "7";
        libreria[0][5] = "";

        libreria[1][0] = "Arancia Meccanica";
        libreria[1][1] = "Anthony Burgess";
        libreria[1][2] = "1969";
        libreria[1][3] = "Romanzo";
        libreria[1][4] = "4";
        libreria[1][5] = "";

        libreria[2][0] = "Fight Club";
        libreria[2][1] = "Chunk Palanhniuk";
        libreria[2][2] = "1996";
        libreria[2][3] = "Thriller";
        libreria[2][4] = "8";
        libreria[2][5] = "";

        libreria[3][0] = "Abissi D'acciaio";
        libreria[3][1] = "Isaac Asimov";
        libreria[3][2] = "1954";
        libreria[3][3] = "SciFi";
        libreria[3][4] = "3";
        libreria[3][5] = "";

        libreria[4][0] = "The Mamba Mentality";
        libreria[4][1] = "Kobe Bryant";
        libreria[4][2] = "2018";
        libreria[4][3] = "Biografia";
        libreria[4][4] = "7";
        libreria[4][5] = "";

        libreria[5][0] = "Educazione Siberiana";
        libreria[5][1] = "Nicolai Lilin";
        libreria[5][2] = "2009";
        libreria[5][3] = "Romanzo";
        libreria[5][4] = "5";
        libreria[5][5] = "";
		
		//recensioni
        String[][][] recensioni = new String[10][10][3];

        // indice 1 libro
        // indice 2 recensione
        // indice 3 proprietá
           
        // recensione libro 1
        
        recensioni[0][0][0] = "Mario Rossi";
        recensioni[0][0][1] = "Fantastico!";
        recensioni[0][0][2] = "5";

        recensioni[0][1][0] = "Giacomo Rossi";
        recensioni[0][1][1] = "Fantastico!";
        recensioni[0][1][2] = "4";
        
        // recensione libro 2
        
        recensioni[1][0][0] = "Giacomo Rossi";
        recensioni[1][0][1] = "Fantastico!";
        recensioni[1][0][2] = "4";

        recensioni[1][1][0] = "Luca Bianchi";
        recensioni[1][1][1] = "Mi è piaciuto molto!";
        recensioni[1][1][2] = "5";

        // recensione libro 3
        recensioni[2][0][0] = "Luca Bianchi";
        recensioni[2][0][1] = "Molto interessante!";
        recensioni[2][0][2] = "4";

        recensioni[2][1][0] = "Mario Rossi";
        recensioni[2][1][1] = "Fantastico!";
        recensioni[2][1][2] = "5";

        // recensione libro 4
        recensioni[3][0][0] = "Anna Verdi";
        recensioni[3][0][1] = "Mi è piaciuto molto!";
        recensioni[3][0][2] = "5";

        recensioni[3][1][0] = "Michele Rossi";
        recensioni[3][1][1] = "Fantastico!";
        recensioni[3][1][2] = "5";

        // recensione libro 5
        recensioni[4][0][0] = "Marco Neri";
        recensioni[4][0][1] = "Un libro affascinante!";
        recensioni[4][0][2] = "5";

        recensioni[4][1][0] = "Francesco Rossi";
        recensioni[4][1][1] = "Fantastico!";
        recensioni[4][1][2] = "5";

        // recensione libro 6
        recensioni[5][0][0] = "Anna Verdi";
        recensioni[5][0][1] = "Mi è piaciuto molto!";
        recensioni[5][0][2] = "5";

        recensioni[5][1][0] = "Giacomo Rossi";
        recensioni[5][1][1] = "Fantastico!";
        recensioni[5][1][2] = "4";
        
	
		
		
		System.out.println("Ecco l'elenco completo dei libri disponibili per valutazione media: ");
				
		// riempimento dei valori delle valutazioni medie
		for (int i = 0; i < grandezzaLibreria; i++) {

		    indiceRecensione = 0; // re-set dell'indice

		    
		    // calcola il numero di recensioni nel libro

		    for (int j = 0; j < recensioni[i].length; j++) {
		        if (recensioni[i][j][2] != null) {
		            indiceRecensione++; // calcolo del numero di recensioni in un libro, se il libro é presente incrementa l'indice se no non fa nulla.
		        }
		    }

		    //valutazione media

		    media = 0; // re-set della media
		    for (int j = 0; j < indiceRecensione; j++) {
		        media += Integer.parseInt(recensioni[i][j][2]); // somma delle valutazioni
		    }

		    float inRec = indiceRecensione; // conversione in float
		    float valutazioneMedia = (inRec > 0) ? media / inRec : 0; 
                // se l'espressione (inRec > 0) é vera allora valutazioneMedia = media/inRec altrimenti valutazioneMedia = 0 
		    
		

            
            // conversione in stringa
            
            String valutazioneMediaString = Float.toString(valutazioneMedia);
            
            // aggiunta valore 
            
            libreria[i][5] = valutazioneMediaString;
           
        }
		
		
		
        // ordina i libri per valutazioneMedia
		for (int i = 0; i < grandezzaLibreria; i++) {   // seleziona il primo libro
		    for (int j = i + 1; j < grandezzaLibreria; j++) {   // seleziona il secondo libro
		        if (Float.parseFloat(libreria[i][5]) < Float.parseFloat(libreria[j][5])) {
		            String[] temp = libreria[i]; // stringa temporanea per lo scambio dei valori
		            libreria[i] = libreria[j];
		            libreria[j] = temp;
		        }
		    }
		}
        
		for(int i = 0; i < grandezzaLibreria; i++) {
			System.out.println("Libro#" + (i+1));
			System.out.println("Titolo: " + libreria[i][0]);
			System.out.println("Autore: "+ libreria[i][1]);
			System.out.println("Anno: "+ libreria[i][2]);
			System.out.println("Valutazione: "+ libreria[i][5]);

			System.out.println();
		}
	}
}
