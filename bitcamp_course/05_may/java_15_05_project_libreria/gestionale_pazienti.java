package java_15_05;

public class gestionale_pazienti {
    
    public static void main(String[] args) {

        // bi-dimensional array to store the data of the patients
        
        String[][] pazienti = new String[5][4]; 
        // in this way you create a bi-dimensional array with 5 rows and 4 columns

        // insert the data of the patients

        // column 0: name
        // column 1: age
        // column 2: genre
        // column 3: weight
        // column 4: blood group
        
        pazienti[0][0] = "Mario Rossi";
        pazienti[0][1] = "25";
        pazienti[0][2] = "M";
        pazienti[0][3] = "Negativo";

        pazienti[1][0] = "Anna Bianchi";
        pazienti[1][1] = "35";
        pazienti[1][2] = "F";
        pazienti[1][3] = "Positivo";

        pazienti[2][0] = "Giovanna Neri";
        pazienti[2][1] = "45";
        pazienti[2][2] = "F";
        pazienti[2][3] = "Positivo";

        pazienti[3][0] = "Carlo Verdi";
        pazienti[3][1] = "50";
        pazienti[3][2] = "M";
        pazienti[3][3] = "Negativo";

        pazienti[4][0] = "Luca Gialli";
        pazienti[4][1] = "30";
        pazienti[4][2] = "M";
        pazienti[4][3] = "Negativo";

        // print the data of the patients

        System.out.println("Elenco dei pazienti:");
        System.out.println("--------------------");
        System.out.println();

        for(int i = 0; i < pazienti.length; i++){
            System.out.println("Nome: " + pazienti[i][0]);
            System.out.println("Etá: " + pazienti[i][1]);
            System.out.println("Genere: " + pazienti[i][2]);
            System.out.println("Gruppo sanguigno: " + pazienti[i][3]);
            System.out.println();
        }



    }
}
