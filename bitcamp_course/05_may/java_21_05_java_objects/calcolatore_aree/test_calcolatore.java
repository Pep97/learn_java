package java_21_05_objects.calcolatore_aree;

public class test_calcolatore {

    public static void main(String[] args) {
        
        // dichiarazione delle istanze

        Cerchio c1 = new Cerchio(5.0);
        Quadrato q1 = new Quadrato(4.0);
        Rettangolo r1 = new Rettangolo(6.0, 3.0);

        // stampa delle aree degli oggetti istanziati ed inizializzati.

        System.out.println("Il cerchio ha raggio " + c1.getRaggio() + " e area " + c1.calcolaArea());
        System.out.println("Il quadrato ha lato " + q1.getLato() + " e area " + q1.calcolaArea());
        System.out.println("Il rettangolo ha base " + r1.getbase() + " e altezza " + r1.getAltezza() + " e area " + r1.calcolaArea());


        // diamo un nuovo valore al lato del quadrato

        q1.setLato(5.0);
        System.out.println("Il quadrato con il nuovo lato " + q1.getLato() + " e area " + q1.calcolaArea());













    }
    
}
