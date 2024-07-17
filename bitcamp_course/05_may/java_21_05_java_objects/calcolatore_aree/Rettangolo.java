package java_21_05_objects.calcolatore_aree;

public class Rettangolo {


    // attributi

    private double base;
    private double altezza;

    // costruttori

    public Rettangolo(double base, double altezza){
        this.base = base;
        this.altezza = altezza;
    }

    // metodi getter e setter

    public double getbase(){
        return base;
    }
    public double getAltezza(){
        return altezza;
    }

    public void setBase(double base){
        this.base = base;
    }

    public void setAltezza(double altezza){
        this.altezza = altezza;
    }

    // altri metodi
    public double calcolaArea(){
        return base * altezza;
    }


    
}
