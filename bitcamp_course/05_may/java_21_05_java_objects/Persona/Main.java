package java_21_05_objects.Persona;

public class Main {

    public static void main(String[] args) {

        // creazione istanza della classe persona - copia dell'oggetto Persona(Classe)
        Persona persona = new Persona("Mario", 35);
        Persona persona2 = new Persona("Laura", 27);

        String nominativo = persona.getNome();
        System.out.println(nominativo);

        nominativo = persona2.getNome();
        System.out.println(nominativo);

        persona.setNome("Giovanni");
        nominativo = persona.getNome();
        System.out.println(nominativo);







    }
    
}
