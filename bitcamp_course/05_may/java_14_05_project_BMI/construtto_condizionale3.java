package java_14_05;

public class construtto_condizionale3 {
    
    public static void main(String[] args) {
        
        int scelta = 2;
        String risultato;

        switch(scelta){
            case 1:
                risultato = "Hai scelto il primo caso";
                break;
            case 2:
                risultato = "Hai scelto il secondo caso";
                break;
            default:
                risultato = "Hai scelto un caso non previsto";
        }

        
        System.out.println("La scelta effettuata é: " + scelta);
        System.out.println(risultato);
    }
}
