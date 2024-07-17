package java_14_05;

import java.util.Scanner;

public class progetto_calcolo_bmi {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //dichiarazione delle variabili
        float altezza = 0;
        float peso = 0;
        float bmi = 0;
        String scelta = "si";
        boolean sceltaBooleana;

        // Sottopeso BMI<18.5
        //Normopeso 18.5<=BMI<25
        //Sovrappeso 25<=BMI<30
        //Obesità BMI>=30

        System.out.println("Benvenuto scopri il tuo indice di massa grassa (BMI)");
        System.out.println();

	    do {
	
	        System.out.println("Inserisci il tuo peso in kg (esempio: 65):");
	        peso = scanner.nextFloat();
	        while (peso <= 0) {
	            System.out.println("Peso non valido, inserire un nuovo valore");
	            peso = scanner.nextFloat();
	        } 
	        System.out.println("Inserisci la tua altezza in mr (esempio: 1.70) :");
	        altezza = scanner.nextFloat();
	        while (altezza <= 0 || altezza > 3) {
	            System.out.println("Altezza non valida, inserire un nuovo valore");
	            altezza = scanner.nextFloat();
	
	        } 
	        
            bmi = peso / (altezza * altezza);

            if (bmi < 18.5) {
                System.out.println("Il tuo indice di BMI è pari a " + bmi + " ovvero sei Sottopeso");
            } else if ((18.5 <= bmi) && (bmi <25)) {
                System.out.println("Il tuo indice di BMI è pari a " + bmi + " ovvero sei Normopeso");
            } else if ((25<= bmi) && (bmi <30)) {
                System.out.println("Il tuo indice di BMI è pari a " + bmi + " ovvero sei Sovrappeso");
            } else  {
                System.out.println("Il tuo indice di BMI è pari a " + bmi + " ovvero sei Obeso");
            }


            
	        System.out.println("Vuoi calcolare il BMI di un'altra persona? digita si per continuare o no per fermarti");
	        scelta = scanner.next();
	        
	        	        
	        do{
	        	
		        if (scelta.equals("si")) {
			        sceltaBooleana = true; // diventa vero
		        } else if (scelta.equals("no")){
		        	sceltaBooleana = false; // diventa falso
		        } else {
		        	System.out.println("Per favore, inserisci 'si' o 'no'");
			        scelta = scanner.next();
		        }
		       } while(!scelta.equals("si") && !scelta.equals("no"));
	        
            sceltaBooleana = scelta.equals("si");

	        	
	        
	        
	        
	        
	       
	        

        } while (sceltaBooleana == true);
	    
	    System.out.println("Grazie per aver utilizzato il nostro Calcolatore BMI, alla prossima!");
	    




    }

}
