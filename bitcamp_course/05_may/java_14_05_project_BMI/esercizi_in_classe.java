package java_14_05;

public class esercizi_in_classe {

    public static void main(String[] args) {

        // consegna 12:24


        // Esercizio 1

        System.out.println("Esercizio 1");

        // Creare un programma che sommi due numeri e ne stampi il risultato solo se una terza variabile è uguale a true

        int num1 = 10;
        int num2 = 20;
        boolean condizione = true;

        if(condizione == true){
            int somma = num1 + num2;
            System.out.println("La somma dei due numeri é: " + somma);
        }

        // Esercizio 2

        System.out.println("Esercizio 2");

        // Scrivere un programma che chieda due variabili per la lunghezza e la larghezza del rettangolo e quindi utilizzi gli operatori matematici per calcolarne l'area e il perimetro

        int lunghezza = 10;
        int larghezza = 20;

        int area = lunghezza * larghezza;
        int perimetro = 2 * (lunghezza + larghezza);

        System.out.println("L'area del rettangolo é: " + area);
        System.out.println("Il perimetro del rettangolo é: " + perimetro);

        // Esercizio 3

        System.out.println("Esercizio 3");

        // Creare una variabile con un numero intero e verificare se quel numero sia maggiore o uguale a 10 in caso affermativo il programma deve stampare la risposta adeguata

        int numero_intero = 5;
        
        if (numero_intero >= 10) {
            System.out.println("Il numero é maggiore o uguale a 10");
        } else {
            System.out.println("Il numero é minore di 10");
        }

        // Esercizio 4

        System.out.println("Esercizio 4");

        // Scrivere un programma che dato due valori numerici controlli se entrambi siano maggiori di zero in caso affermativo il programma deve stampare "entrambi i numeri sono maggiori di zero" altrimenti deve stampare "almeno uno dei numeri è <= 0"

        int valori_numeri = 5;
        int valori_numeri2 = 20;

        if(valori_numeri > 0 && valori_numeri2 > 0){
            System.out.println("Entrambi i numeri sono maggiori di zero");
        } else {
            System.out.println("Almeno uno dei numeri è <= 0");
        }

        // Esercizio 5

        System.out.println("Esercizio 5");

        // Creare un programma che dato un numero intero verifichi se questo valore sia pari o dispari e ne stampi il risultato

        int numero = 10;

        switch (numero % 2) {
            case 1:
                System.out.println("Il numero é pari");
                break;
            default:
                System.out.println("Il numero é dispari");
        }

        // Esercizio 6

        System.out.println("Esercizio 6");

        // Creare un programma che dato un numero intero tra 1 e 7 ne rappresenti il giorno della settimana corrispondente ovvero se inserisce 1 il programam dovrà stampare Lunedì

        int giorno = 1;

        switch (giorno) {
            case 1:
                System.out.println("Lunedì");
                break;
            case 2:
                System.out.println("Martedì");
                break;
            case 3:
                System.out.println("Mercoledì");
                break;
            case 4:
                System.out.println("Giovedì");
                break;
            case 5:
                System.out.println("Venerdì");
                break;
            case 6:
                System.out.println("Sabato");
                break;
            case 7:
                System.out.println("Domenica");
                break;
            
            default:
                System.out.println("Il numero del giorno non é valido");
                break;
        }


    }
    
}
