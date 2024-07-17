package java_15_05;

import java.util.Scanner;

public class distributore_film_next_gen {

    public static void main(String[] args) {

        // istanza di scanner
        Scanner scanner = new Scanner(System.in);

        // bi-dimensional array to store the data of the movies

        String[][] videoteca = new String[3][4];

        // insert the data of the movies

        videoteca[0][0] = "Il Signore degli Anelli";
        videoteca[0][1] = "Peter Jackson";
        videoteca[0][2] = "Fantasy";
        videoteca[0][3] = "2001";

        videoteca[1][0] = "La vita é bella";
        videoteca[1][1] = "Roberto Benigni";
        videoteca[1][2] = "Commedia";
        videoteca[1][3] = "1997";

        videoteca[2][0] = "Il padrino";
        videoteca[2][1] = "Francis Ford Coppola";
        videoteca[2][2] = "Drammatico";
        videoteca[2][3] = "1972";


        // print the data of the movies

        System.out.println("Lista dei film nella videoteca");
        System.out.println("------------------------------");

        for(int i = 0; i < videoteca.length; i++) {
            System.out.println("Film # " + (i + 1));
            System.out.println("Titolo: " + videoteca[i][0]);
            System.out.println("Regista: " + videoteca[i][1]);
            System.out.println("Anno di Uscita: " + videoteca[i][3]);
            System.out.println("Genere: " + videoteca[i][2]);
            System.out.println();
        }

        // search a movie by title
        System.out.println("Inserisci il titolo del film che vuoi cercare");
        String titolo = scanner.nextLine();

        boolean trovato = false;

        for(int i = 0; i < videoteca.length; i++) {
            if(videoteca[i][0].equalsIgnoreCase(titolo)) {
           
            	trovato = true;
            	System.out.println("Film trovato:");
            	System.out.println("Titolo: " + videoteca[i][0]);
                System.out.println("Genere: " + videoteca[i][2]);
                System.out.println("Anno di Uscita: " + videoteca[i][3]);
                break;
            }
        }
        
        if(!trovato) {
        	System.out.println("Film non presente nella videoteca");
        }




        
    }
    
}
