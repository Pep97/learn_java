package java_22_05.supermercato;

public class Offerta {

    //attributi
    Prodotto prodotto;
    double sconto;
    String dataInizio;
    String dataFine;
    String prodotto1;

    //metodo costruttore
    public Offerta(Prodotto prodotto, double sconto, String dataInizio, String dataFine) {
        this.prodotto = prodotto;
        this.sconto = sconto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    // public Offerta(){
    //     this.prodotto = null;
    //     this.sconto = 0.0;
    //     this.dataInizio = "";
    //     this.dataFine = "";
    // }

    //metodi Getter e setter
    //Getter

    public Offerta(String prodotto, double sconto, String dataInizio, String dataFine) {
        this.prodotto1 = prodotto;
        this.sconto = sconto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public String getProdotto1() {
        return prodotto1;
    }

    public double getSconto() {
        return sconto;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    //metodo Setter

    public void setProdotto(String prodotto) {
        this.prodotto1 = prodotto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String toString() {
        return prodotto + " | Sconto: " + sconto + "% " + " | Data Inizio: " + dataInizio + " | Data Fine: " + dataFine + ".";
    }



}
