package java_21_05_objects.aci;

import java.util.Calendar;

public class Automobile {

    private String marca;
    private String modello;
    private int anno;
    private int cilindrata;

    public Automobile(String marca, String modello, int anno, int cilindrata) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    // metodo per stampa informazioni autobile
    public void stampaInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Cilindrata: " + cilindrata);
    }

    // metodo calcolo tassa

    public double tassaAutomobilistica(){
        double tassaBase = 100;
        double tassaCilindrata = 0.5 * cilindrata;
        double tassaAnno = 50 * (Calendar.getInstance().get(Calendar.YEAR) - anno);
        return tassaBase + tassaCilindrata + tassaAnno;
    }
    
}
