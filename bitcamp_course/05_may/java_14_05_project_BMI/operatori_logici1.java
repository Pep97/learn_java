package java_14_05;

// to run

// javac java_14_05/file1.java
// java java_14_05.file1

public class operatori_logici1 {

    public static void main(String[] args) {

        String nome = "Mario";
		int eta = 30;
		
		System.out.println("Il nominativo é: " + nome + " etá " + eta + "anni");


        // definizione di una constatente

        final double PI = 3.14159;

        double raggio = 5.0;

        double area = PI * raggio * raggio;

        System.out.println("L'area del cerchio con raggio: " + raggio + " é " + area);


        // new file

        int a = 10;
		int b = 5;
		
		int somma = a + b;
		int differenza = a - b;
		int prodotto = a * b;
        int quoziente = a / b;
		int resto = a % b;

        System.out.println("La somma é: " + somma);
        System.out.println("La differenza é: " + differenza);
        System.out.println("Il prodotto é: " + prodotto);
        System.out.println("Il quoziente é: " + quoziente);
        System.out.println("Il resto é: " + resto);

        // operatori logici

        // if a boolean isn't declared by default it's false

        boolean p = true;
        boolean q = false;
        boolean r = true;

        boolean congiunzione = p && q;
        boolean disgiunzione = p || q;
        boolean negazione = !p;
        boolean condizionale = (p && r) || q;

        System.out.println("Congiunzione: " + congiunzione);
        System.out.println("Disgiunzione: " + disgiunzione);
        System.out.println("Negazione: " + negazione);
        System.out.println("Condizionale: " + condizionale);

		


    }
    
}
