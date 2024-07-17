package java_21_05_objects.aci;

public class calcola_tassa {

    public static void main(String[] args) {
        
        // istanza automobile
        Automobile auto = new Automobile("Fiat", "Panda", 2010, 1200);

        System.out.println("La tassa automobilistica per la seguente auto:");
        System.out.println();
        auto.stampaInfo();
        double tassa = auto.tassaAutomobilistica();
        System.out.println("Tassa: " + tassa);
    
    
    
    }
}
