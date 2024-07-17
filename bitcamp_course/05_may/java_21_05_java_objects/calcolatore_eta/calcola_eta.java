package java_21_05_objects.calcolatore_eta;

public class calcola_eta {
    
    public static void main(String[] args) {
        
        Persona persona = new Persona("Mario", "Rossi", 35);
        int annoNascita = persona.annoDiNascita();

        persona.stampaInfo();
        System.out.println("Anno di nascita: " + annoNascita);

        // System.out.println("Anno di nascita di " + persona.nome);
        // you can't do this because nome is private (with voide) you have to create the method getNome() in the class Persona

    }
}
