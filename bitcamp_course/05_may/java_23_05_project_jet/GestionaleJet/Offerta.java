package java_23_05.GestionaleJet;

public class Offerta {
    String nomeOfferta;
    double sconto;


    //costruttore
    public Offerta(String nomeOfferta, double sconto) {
        this.nomeOfferta = nomeOfferta;
        this.sconto = sconto;

    }

    //getter

    public  String getNomeOfferta() {
        return nomeOfferta;
    }

    public double getSconto() {
        return sconto;
    }

    //setter

    public void setNomeOfferta(String nomeOfferta) {
        this.nomeOfferta = nomeOfferta;
    }
    public void setSconto(double sconto) {
        this.sconto = sconto;
    }


    //metodo to string
    public String toString() {
          return nomeOfferta + " | sconto: " + sconto;
    }

}