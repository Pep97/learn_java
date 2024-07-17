package java_15_05;

public class arrayExercise {
    
    public static void main(String[] args) {
        
        int[] numeri = {1,2,3,4,5};

        
        for(int i = 0; i < numeri.length; i++) {

            int quadrato = numeri[i] * numeri[i];
            System.out.println("Il valore dell'indice " + i + " al quadrato é " + quadrato);

            // in this way you print the value of each element inside the array
        }

        System.out.println("I valori dispari dell'array sono: ");

        for(int i = 0; i < numeri.length; i++) {
            if(numeri[i] % 2 != 0) {
                System.out.println(numeri[i]);
            }
        }
    }
}
