package java_14_05;

// to run

// javac java_14_05/loop2.java
// java java_14_05.loop2

import java.util.*; 

// in this way you're importing all the classes in the java.util package
// this is used for small projects because all the libraries can be heavy

public class loop2 {

    public static void main(String[] args) {

        // instantiation of the Scanner library
        Scanner scanner = new Scanner(System.in);

        // dichiarazione delle variabili 
        int somma = 0;
        int numero = 0;

        while(true) {
            System.out.println("Inserisci un numero intero positivo da sommare (inserisci un numero negativo per uscire)");
            
            // intercept the input value from the user.
            
            numero = scanner.nextInt();

            // nextInt() -> take an interger number
            // nextFloat() -> take number with decimal
            // nextLine()  -> take strings
            // next() -> take on the first string of a text
            
            // conditional to interrupt the infinite loop
            if(numero < 0) {
                break;
            }

            // code to sum the numbers
            somma += numero;
        }

        // print the sum of the numbers
        System.out.println("La somma dei numeri inseriti è: " + somma);
    }
    
}
