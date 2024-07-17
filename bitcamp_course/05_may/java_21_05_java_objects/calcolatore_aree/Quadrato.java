package java_21_05_objects.calcolatore_aree;

public class Quadrato {
    
    private double lato;

    public Quadrato(double lato){
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    public double calcolaArea(){
        return lato * lato;
    }
}
