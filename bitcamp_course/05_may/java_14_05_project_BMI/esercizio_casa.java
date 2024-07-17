package java_14_05;

// to run

// javac java_14_05/esercizio_casa.java
// java java_14_05.esercizio_casa

import java.util.Scanner;

public class esercizio_casa {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // esercizio 1

        int num1 = 0;
        int num2 = 0;

        System.out.println("Inserisci il primo numero intero");
        num1 = scanner.nextInt();
        
        System.out.println("Inserisci il secondo numero intero");
        num2 = scanner.nextInt();

        int somma = num1 + num2;
        System.out.println("La somma dei due numeri è: " + somma);

        // esercizio 2

        float numero1 = 0;
        float numero2 = 0;
        float numero3 = 0;

        System.out.println("Inserisci il primo numero");
        numero1 = scanner.nextFloat();

        System.out.println("Inserisci il secondo numero");
        numero2 = scanner.nextFloat();

        System.out.println("Inserisci il terzo numero");
        numero3 = scanner.nextFloat();

        if (numero1 > numero2 && numero1 > numero3) {
            System.out.println("Il numero più grande è: " + numero1);
        } else if (numero2 > numero1 && numero2 > numero3) {
            System.out.println("Il numero più grande è: " + numero2);
        } else {
            System.out.println("Il numero più grande è: " + numero3);
        }

        // esercizio 3










    }

}