package java_21_05_objects.concessionaria;

public class Automobile {

    private String marca;
    private String modello;
    private int anno;
    private double prezzo;

    public Automobile(String marca, String modello, int anno, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    // metodi getter e setter

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getAnno() {
        return anno;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // é possibile fare un loop che crea tutti i getter e setter?

    public void stampaInfo(){
        System.out.println(" Marca: " + marca + "\n Modello: " + modello + "\n Prezzo: " + prezzo +"\n Anno: " + anno);
    }
    
}
