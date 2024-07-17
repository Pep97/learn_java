package java_22_05.supermercato;

public class Prodotto {
    //Attributi
    String nome;
    String categoria;
    double prezzo;

    //metodi
    public Prodotto(String nome, String categoria, double prezzo) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    //metodi getter e setter
    //metodo getter
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    //metodi setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //metodo to string
    public String toString() {
        return "Nome Prodotto: "+ nome + " | Categoria Prodotto: " + categoria + "  | Prezzo: " + prezzo + " Euro";
    }



}