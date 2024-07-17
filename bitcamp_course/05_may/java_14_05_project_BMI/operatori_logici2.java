package java_14_05;

// to run

// javac java_14_05/file2.java
// java java_14_05.file2

public class operatori_logici2 {
    
    public static void main(String[] args) {
        
        int a = 10;
		int b = 5;
		int c = 20;
		boolean x = true;
		boolean y = false;

        // utilizzo di piú operatori logici in una singola espressione

        boolean espressione1= (a > b) && (c > a) || (a < b);
        boolean espressione2 = !(x && y) || (x || y);

        // utilizzo di operatori logici annidati
        boolean espressione3 = (a > b) && ((c > a) || (a < b));
        boolean espressione4 = ((x && !y) || (y && !x) && (x || y));

        System.out.println("Espressione1: " + espressione1);
        System.out.println("Espressione2: " + espressione2);
        System.out.println("Espressione3: " + espressione3);
        System.out.println("Espressione4: " + espressione4);
    }
}
