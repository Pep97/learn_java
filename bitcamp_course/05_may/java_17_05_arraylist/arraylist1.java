package java_17_05;

import java.util.ArrayList;

public class arraylist1 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> numeri = new ArrayList<>();

        // data type
        // int, float, double, short, long, byte, char, boolean

        // Java Library that contains objects
            // objects contain functions that are called methods
            // ArrayList works with objects

        // Integer, Float, Double, Short, Long, Byte, Character, Boolean 

        // add elements to the arraylist

        numeri.add(0, 5); // select the index and the value
        numeri.add(1, 10);
        numeri.add(2, 15);

        // add element to the arraylist it will be added at the end

        numeri.add(18); 
        numeri.add(28);
        numeri.add(38);



        // get elements from the arraylist

        int primo_numero = numeri.get(0);
        int secondo_numero = numeri.get(1);
        int terzo_numero = numeri.get(2);

        System.out.println(numeri);

        // remove elements from the arraylist

        numeri.remove(1); // remove with the index
        numeri.remove(Integer.valueOf(5)); 
        // remove with the value -> it will find the first occurrence of the value in the index and delete it

        System.out.println(numeri);
        System.out.println("hello");

        // size of the arraylist

        int size = numeri.size();

        System.out.println("size: " + size);

        // loop through the arraylist

        for(int i = 0; i < numeri.size(); i++) {
            System.out.println(numeri.get(i));
        }

        // foreach loop

        System.out.println("Foreach Loop ");


        for(Integer x : numeri){
            System.out.println(x);
        }

        /*  Here's a step-by-step explanation of how it works:

            for(Integer x : numeri): This is the start of the for-each loop. It declares a variable x of type Integer and iterates over each element in the numeri ArrayList. For each iteration, x is assigned the value of the current element.
        
             System.out.println(x);: This line is executed for each element in the numeri ArrayList. It prints the value of x (the current element) to the console.
        
        */





    }
}
