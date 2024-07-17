package java_15_05;

public class for_loop {

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {
			
            System.out.println(i);

			if(i == 5) {
				break; // stop loop
			}
		}
		
		System.out.println("fine del ciclo FOR 1");
        
        for(int i = 1; i <= 10; i++) {
			
			if(i == 5) {
				continue; // interrompe l'iterazione corrente e passa alla successiva
			}

            System.out.println(i);

		}
		
		System.out.println("fine del ciclo FOR 2");
    }
    
}
