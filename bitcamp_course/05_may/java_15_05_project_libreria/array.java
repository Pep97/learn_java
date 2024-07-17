package java_15_05;

public class array {
    
    public static void main(String[] args) {

        // Mono-dimensional array
        
        int[] numeri = {1,2,3,4,5};
        // if you write int[] you're telling to java that you want to 
        // create an array
        
        for(int i = 0; i < numeri.length; i++) {
            System.out.println("Il valore dell'indice " + i + " é " +numeri[i]);

            // in this way you print the value of each element inside the array
        }


        int [] array1D = {1,2,3,4,5};

        // to access the first element of the array
        int primoElemento = array1D[0];
        System.out.println("Primo elemento dell'arra1D: " + primoElemento);

        // modify the third element of the array
        array1D[2] = 10;
        System.out.println("Terzo elemento dell'array1D dopo la modifica: " + array1D[2]);

        // Bi-dimensional array

        int [][] array2D = {
            {1,2},
            {3,4},
            {5,6}
        };

        // to access the first element of the array
        int primoElemento2D = array2D[0][1];
        System.out.println("Primo elemento dell'array2D: " + primoElemento2D);

        // modify an array in the position 1 - 1
        array2D[1][1] = 10;
        System.out.println("Elemento dell'array2D dopo la modifica: " + array2D[1][1]);

        // loop inside a bi-dimensional array

        for(int i = 0; i < array2D.length; i++) {
            for(int j = 0; j < array2D[i].length; j++) {
                System.out.println(array2D[i][j] + " ");
            }
            System.out.println();
        }


        // larghezza, altezza, profonditá, tempo (4 dimension)

        // Tri-dimensional array

        // used for scientific calculations or games

        int[][][] array3D = {
            {
                {1,2},
                {3,4}
            },
            {
                {5,6},
                {7,8}
            }
        };

        // print the first element of the arra3D in position 0 - 1 - 0
        int primoElemento3D = array3D[0][0][0];
        System.out.println("Primo elemento dell'array3D: " + primoElemento3D);

        // print all the elements of the array3D
        for(int i = 0; i < array3D.length; i++) {
            for(int j = 0; j < array3D[i].length; j++) {
                for(int k = 0; k < array3D[i][j].length; k++) {
                    System.out.println(array3D[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }






    }
}
