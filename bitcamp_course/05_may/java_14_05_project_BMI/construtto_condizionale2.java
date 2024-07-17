package java_14_05;

public class construtto_condizionale2 {

    public static void main(String[] args) {
		
		int num = 2;

        // construtto if

        if (num == 1 ){
            System.out.println("Il numero é 1");
        } else if (num == 2) {
            System.out.println("Il numero é 2");
        } else if (num == 3) {
            System.out.println("Il numero é 3");
        } else {
            System.out.println("Il numero non é nè 1 nè 2 nè 3");
        }

        // construtto switch

        num = 3;

        switch(num){
            case 1:
                System.out.println("Il numero é 1");
                break;
            case 2:
                System.out.println("Il numero é 2");
                break;
            case 3:
                System.out.println("Il numero é 3");
                break;
            default:
                System.out.println("Il numero non é nè 1 nè 2 nè 3");
        }
		
	}
    
}
