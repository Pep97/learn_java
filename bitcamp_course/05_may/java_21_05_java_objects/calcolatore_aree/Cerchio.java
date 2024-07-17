package java_21_05_objects.calcolatore_aree;

public class Cerchio {

    // attributi

    private double raggio;

    // costruttori

    public Cerchio(double raggio){
        this.raggio = raggio;
    }

    // metodi getter e setter

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    // altri metodi

    public double calcolaArea(){
        return Math.PI * raggio * raggio;
    }
    
}
