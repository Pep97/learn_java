package java_21_05_objects.treni_italia.stazione;

public class Biglietto {

    // attributi
    private String destinazione;
    private double prezzo;

    // costruttore
    public Biglietto(String destinazione) { // String destinazione -> parametro
        this.destinazione = destinazione; 
    }

    public Biglietto(double prezzo){
        this.prezzo = prezzo;
    }

    public Biglietto(String destinazione, double prezzo){
        this.destinazione = destinazione;
        this.prezzo = prezzo;
    }

    // overloeading -> pratica in java che si crea quando si utilizzano gli stessi attributi
    // e vengono creati diversi costruttori ma con diversi parametri

    public Biglietto(double prezzo, String destinazione){
        this.destinazione = destinazione;
        this.prezzo = prezzo;
    }

    // metodo per il ritorno della stringa contente il biglietto

    // metodo di default creato dalla classe -> toString
    @Override // Override -> sovrascrive il metodo toString
    public String toString(){
        return destinazione + " (" + prezzo + " euro)";
    }



}
