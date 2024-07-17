package java_15_05;

import java.util.Scanner;

public class calcolatore_aree {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int scelta;

        do{

            // print the menu
            System.out.println("Seleziona una figura Geometrica");
            System.out.println("Per il calcolo dell'area");
            System.out.println("--------------------------------");
            System.out.println("1. Quadrato");
            System.out.println("2. Rettangolo");
            System.out.println("3. Triangolo");
            System.out.println("4. Cerchio");
            System.out.println("0. Esci");

            // take the user's choice
            System.out.println("Scegli ==> ");
            scelta = scanner.nextInt();

            int intValue = 10;
            float floatValue = (float) intValue;

            // calculate the area based on the user's choice
            switch(scelta){
                case 1:
                    System.out.println("Inserisci la lunghezza del quadrato:");
                    double lato = scanner.nextDouble();
                    double area_quadrato = lato * lato;
                    System.out.println("L'area del quadrato é: " + area_quadrato);
                    break;
                case 2:
                    System.out.println("Inserisci la lunghezza della base:");
                    double base = scanner.nextDouble();
                    System.out.println("Inserisci l'altezza del rettangolo:");
                    double altezza = scanner.nextDouble();
                    double area_rettangolo = base * altezza;
                    System.out.println("L'area del rettangolo é: " + area_rettangolo);
                    break;
                case 3:
                    System.out.println("Inserisci la lunghezza della base:");
                    double base_triangolo = scanner.nextDouble();
                    System.out.println("Inserisci l'altezza del triangolo:");
                    double altezza_triangolo = scanner.nextDouble();
                    double area_triangolo = (base_triangolo * altezza_triangolo) / 2;
                    System.out.println("L'area del triangolo é: " + area_triangolo);
                    break;
                case 4:
                    System.out.println("Inserisci il raggio del cerchio:");
                    double raggio = scanner.nextDouble();
                    double area_cerchio = Math.PI * raggio * raggio;
                    System.out.println("L'area del cerchio é: " + area_cerchio);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova!");
            }


        } while(scelta != 0);

        














        
    }
    
}
