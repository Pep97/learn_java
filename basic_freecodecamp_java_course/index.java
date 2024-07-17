import java.util.Scanner;

// link tutorial https://www.youtube.com/watch?v=A74TOX803D0&t=5787s


/**
 * index
 */

 // import java.util.Scanner;
 // sometimes you need to import a package to use a specific class

 class index { // class name should be same as file name
    // this is because java otherwise also for that new class will be created a file


    // this is the "main method" is the entry point of the program
    public static void main(String[] args) {
        // int -> data type used to represent integer values. 
        // it's a variable that can store a single integer value.

        int age = 20;

        System.out.println("I am " + age + " years old.");

        // number conversion

        double number1 = 10.5;
        int number2 = (int) number1; 
        // if you don't add (int) the number won't be converted to int

        System.out.println("Number is " + number2);
        // result will be 10

        // operators

        int number3 = 12;
        int number4 = 6;

        int sum = number3 + number4;
        int difference = number3 - number4;
        int product = number3 * number4;
        int quotient = number3 / number4;
        // you can also check for a remainder using % operator

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        // if you devide two integers the result will be an integer
        // if you want a decimal result you should use double

        // can also use shorthand operators

        int number5 = 10;
        number5 += 5; // number5 = number5 + 5 = 15

        System.out.println("Number5: " + number5);

        int age1 = 25;

        System.out.println(age1 >= 18 && age1 <= 40); //true

        boolean isStudent = false;
        boolean isLibraryMember = true;

        System.out.println(isStudent || isLibraryMember); //true

        //not operator

        System.out.println(!isStudent); //true

        // --------------------------------------------------------------


        int score = 0;
        int turns = 10;

        score ++; // score = score + 1
        turns --; // turns = turns - 1

        System.out.println("Score: " + score + " Turns: " + turns);

        // --------------------------------------------------------------

        int randomNumber = 55;

        // the compiler comppiles the code from left to right so at the it compiles "randomNumber" 
        // is 55 and then adds the ++ so in the next line the reuslt will be 56
        System.err.println(randomNumber++); //55
        System.err.println(randomNumber); //56

        // therefore if add ++ before the variable it adds +1 before compiling the code

        System.err.println(++randomNumber); //57

        // --------------------------------------------------------------

        // String name = "John";

        String name = new String("Matt");

        System.out.println("Hello " + name);

        String exampleString1 = "Hello";
        String exampleString2 = "Hello";

        String exampleString3 = new String("Hello");
        String exampleString4 = new String("Hello");

        System.out.println(exampleString1 == exampleString2); //true
        System.out.println(exampleString3 == exampleString4); //false

        // it's false because the strings 3 - 4 are created in the same memory location
        // and == it's checking if the memory location is the same not the value inside the string
        // to check the value inside the string you should use .equals
        // exampleString3.equals(exampleString4); // true

        // --------------------------------------------------------------

        String name3 = "Giuseppe";
        String country = "Italy";
        int age3 = 26;

        System.out.println("Hello world! I'm " + name3 + " from " + country + " and i am " + age3 + " years old");

        String formattedString = String.format("My name is %s, i am %d years old and i am from %s", name3, age3, country);
        // when the compiler sees %s it will replace it with the first argument and so on...
        // %s -> string
        // %d -> integer & long
        // %f -> float & double
        // %c -> char
        // %b -> boolean


        System.out.println(formattedString);

        // --------------------------------------------------------------

        System.out.println(name.length()); // 8
        System.out.println(name.isEmpty()); // false

        name.toUpperCase(); // doesn't change the original string
        System.out.println(name); // Matt
        System.out.println(name.toUpperCase()); // MATT

        name.toLowerCase();
        name.equalsIgnoreCase(name3); // false
        // equalsIgnoreCase is used to compare two strings without taking into account the case

        name.replace("Matt", "Bob"); // doesn't change the original string
        // replace is used to replace a part of the string with another part

        System.out.println(formattedString.contains("Giuseppe")); // true
        // contains is used to check if a string contains a specific substring
        // if "Giuseppe" is in the string "formattedString" it will return true

        // --------------------------------------------------------------

        // take input from the user

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name5 = scanner.nextLine(); // reads the input from the user
        
        System.out.println("Hello " + name5);

        System.out.print("Enter your age: ");
        int age5 = scanner.nextInt();
        
        // cleans up the input buffer

        scanner.nextLine();

        System.out.printf("Nice! %s, it's a good age to be alive!", age5);

        scanner.close();








    }
}

