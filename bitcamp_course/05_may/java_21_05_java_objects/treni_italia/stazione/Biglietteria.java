package java_21_05_objects.treni_italia.stazione;

public class Biglietteria {


    // attributi
    // lista dei biglietti disponibili

    private Biglietto[] biglietti = new Biglietto[10];

    // Numero dei biglietti disponibili
    private int numBiglietti = 0;

    // costruttore
    // in questo caso non è necessario creare un costruttore
    // perchè non ci sono attributi da inizializzare e si utilizza quello di default


    // Acquisto di un biglietto
    public void acquistaBiglietto(String destinazione, double prezzo){
        if(numBiglietti < biglietti.length){
            biglietti[numBiglietti] = new Biglietto(destinazione, prezzo);
            numBiglietti++;
        } else {
            System.out.println("Biglietti esauriti");
        }
    }

    // metodo per visualizzare i biglietti venduti

    public void visualizzaBiglietti(){
        for(int i = 0; i < numBiglietti; i++){
            System.out.println((i + 1) + ". " + biglietti[i]); 
            // biglietti[i] -> richiama il metodo toString() della classe Biglietto
            // toString() é un metodo di default della classe Object, assicurati di modificarla.
        }
    }
    
}
