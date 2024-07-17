package java_23_05.GestionaleJet;

public class Servizi {
    String servizi;
    double prezzoServizi;

    //costruttore
    public Servizi(String serviziJet, double prezzoServizi) {
        this.servizi = serviziJet;
        this.prezzoServizi = prezzoServizi;
        
    }

    //getter
    public String getServizi() {
        return servizi;
    }


    public double getPrezzoServizi() {
        return prezzoServizi;
    }

    //setter
    public void setServizi(String serviziJet) {
        this.servizi = serviziJet;
    }

    public void setPrezzoServizi(double prezzoServizi) {
        this.prezzoServizi = prezzoServizi;
    }

}
