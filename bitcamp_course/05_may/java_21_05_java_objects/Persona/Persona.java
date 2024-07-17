package java_21_05_objects.Persona;

public class Persona {

    // Attributi della classe o proprietá
	// rappresentazione generica dell'entitá
    
    // non modificabile o visibile all'infuori della classe persona
    private String nome;
    private int eta;


    // costrutto metodo speciale che serve ad inizializzare gli attributi

    public Persona(String nome, int eta){

        this.nome = nome;
        this.eta = eta;
    }

    // metodi della classe 

    // metodo getter -> ritorna il valore dell'attributo
    // metodo setter -> modifica il valore dell'attributo

    // public String -> tipo di ritorno del metodo, in questo caso ritorna una stringa
    public String getNome() {
        return nome; 
        // ritorna il valore dell'attributo nome
    }

    public int getEta() {
        return eta;
        // ritorna il valore dell'attributo eta
    }

    public String setNome(String nome) {
        return this.nome = nome;
        // modifica il valore dell'attributo nome
    }









}
