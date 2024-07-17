package java_14_05;

public class construtto_condizionale1 {

    public static void main(String[] args) {
		
		int a = 10;
		int b = 5;
		int c = a + b;
		boolean x = true;
		boolean y = false;
		
		// costrutto condizionale
		
		if(c > 15 && x) {
			System.out.println("La somma in a e b é maggiore di 15 e x é true");
		} else if( c <= 15 || y) {
			System.out.println("La somma di a e b é minore o uguale a 15 o y é true");
		} else { 
            System.out.println("Nessuna delle condizioni precedenti é soddisfatta");
			
		}
	}
    
}
