/*  how to run JS on the terminal

1. Open your terminal.
2. Navigate to the directory where your index.js file is located using the cd command. For example, if your file is in a folder called myProject on your desktop, you would type cd Desktop/myProject.
3. Once you're in the correct directory, you can run your file with the command node index.js.

*/

/*  

// declare 3 variables

var name1 = "John";
var age = 25;
var age2 = "30";
var profession = "Software Developer";
var x =15

// console -> é una libreria e ritorna un risultato testuale di un input e output
// e si chiama il metodo(o funzione) log
// console is a global object that provides access to the console. 
// The console.log() method is used to output messages to the console.


console.log("Name: " + name1);
console.log("Age: " + age);
console.log(x + age);

var price = 10;
console.log("price :" + price);
price = 15;
console.log("price :" + price);

var num1 = 10;
console.log("num1: " + num1);
var num2 = 20;
console.log("num2: " + num2);

var sum = num1 + num2;
console.log("sum: " + sum);

var diff = num1 - num2;
console.log("diff: " + diff);

// boolean

var rain = true;
var sun = false;



// Conditional statement IF

var a = 5;
var b = 10;

if (a > b) {
    console.log("a is greater than b");
} else {
    console.log("a is less than b");
}

var c = 30;
var d = "30";

if (c === d) {
    console.log("a is equal to b");
} else {
    console.log("a is not equal to b");
}

// == check the data inside
// === check the data and the type of the data

if ( a < b && c === d) {
    console.log("a is less than b and a is equal to b");
} else {
    console.log("a is not less than b and a is not equal to b");
}

if ( a < b || c === d) {
    console.log("a is less than b or a is equal to b");
} else {
    console.log("a is not less than b and a is not equal to b");
}



var a = 5;
var b = 10;
var c = 15;

if (a === b && !(a !== b)) {

}

*/

// esercizio 1

var a = 5;
var b = a*2;
var c = a + b;

console.log(c);

// esercizio 2

var string1 = "Hello";
var string2 = 4;

console.log(string2);

// esercizio 3

var string3 = true;
var string4 = false;
var string5 = string3 && string4;

console.log(string5);

// esercizio 4

var num1 = 5;
var string6 = " bye";
var num2 = num1 + string6;

console.log(num2);

// esercizio 5

var a = 10;
var b = 20;

var c = a;
a = b;
b = c;

console.log("Numero a: "+ a+ " Numero b: " + b);
