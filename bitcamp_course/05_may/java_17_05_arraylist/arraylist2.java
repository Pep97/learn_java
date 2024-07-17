package java_17_05;

import java.util.ArrayList;

public class arraylist2 {

    public static void main(String[] args) {
        
        ArrayList<String> lista_stringhe = new ArrayList<>();

        lista_stringhe.add( "Hello");
        lista_stringhe.add( "World");
        lista_stringhe.add( "Java");

        String prima_string = lista_stringhe.get(0);

        lista_stringhe.remove(1);

        for(String stringa : lista_stringhe){
            System.out.println(stringa);
        }

        // contains method -> it will return a boolean

        boolean contiene_x = lista_stringhe.contains("Java");

        System.out.println("Lista stringhe contiene la parola Java? " + contiene_x);

    }
    
}
