package java_21_05_objects.calcolatore_eta;

import java.util.Calendar;

public class Persona {
    
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public void stampaInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Età: " + eta);
    }

    public int annoDiNascita(){
        // librerie per lavorare con le date -> Calendar

        // getInstance() -> restituisce la data corrent
        // get(Calendar.YEAR) -> restituisce l'anno corrente

        return Calendar.getInstance().get(Calendar.YEAR) - eta;
    
    }

}
