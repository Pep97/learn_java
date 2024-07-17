package java_21_05_objects.concessionaria;

public class auto_salone {
    

    public static void main(String[] args) {

        // Creaimo un array di istanze di Automobile

        Automobile[] auto = new Automobile[3];

        // Inizializziamo l'array

        auto[0] = new Automobile("Fiat", "Panda", 2010, 5000);
        auto[1] = new Automobile("Volkswagen", "Golf", 2015, 10000);
        auto[2] = new Automobile("Ford", "Fiesta", 2018, 12000);

        for (int i = 0; i < auto.length; i++) {
            System.out.println();
            auto[i].stampaInfo();
        }
        
    }
}
