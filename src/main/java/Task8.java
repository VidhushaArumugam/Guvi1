import java.util.Scanner;

public class Task8 {
     static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public static void Question1(){//to check if a+b is greater than c+d

        System.out.println("Enter number(a):");
        int a = myObj.nextInt();  // Read user input a
        System.out.println("Enter number(b):");
        int b = myObj.nextInt();  // Read user input b
        System.out.println("Enter number(c):");
        int c = myObj.nextInt();  // Read user input c
        System.out.println("Enter number(d):");
        int d = myObj.nextInt();  // Read user input d
        int Sum1 = a+b;
        int Sum2 = c+d;
        if(Sum1>Sum2){
            System.out.println("Sum of a and b is greater than c and d");
        }
        else{
            System.out.println("Sum of c and d is greater than a and b");
        }
    }

    public static void Question2(){ //Find if a number is even
        System.out.println("Enter number(a):");
        int a = myObj.nextInt();  // Read user input a
        if(a%2==0){
            System.out.println("The number is even");
        }
        else{
            System.out.println("The number is odd");
        }
    }

    public static void Question3(){ //Print characters from A to Z
        char i;
        for(i='A';i<='Z';i++){
            System.out.println(i);
        }

    }
    public static void Question4(){ //Swap two numbers
        int a = 10;
        int b = 20;
        System.out.println("Before Swapping: a is "+a+" and b is "+b);
        int c=b;
        b=a;
        a=c;
        System.out.println("After Swapping: a is "+a+" and b is "+b);
    }
    public static void Question5(){ //Check if a number is prime or not
        System.out.println("Enter number(a):");
        int a = myObj.nextInt();  // Read user input a
        if (a%2==0){
            System.out.println("The number is not prime");
        }
        else if (a<=1){
            System.out.println("The number is not prime");
        }
        else if (a%3==0){
            System.out.println("The number is not prime");
        }
        else if (a%5==0){
            System.out.println("The number is not prime");
        }
        else if (a%7==0){
            System.out.println("The number is not prime");
        }
        else {
            System.out.println("The number is prime");
        }

    }
    public static void Question6(){ //Print factorial
        System.out.println("Enter number(n):");
        int n = myObj.nextInt();  // Read user input a
        int factorial = 1;
        for(int i=1;i<=n;i++){
            factorial=factorial*i;
        }
        System.out.println("Factorial of "+n+" is: "+factorial);
    }
    public static void Question7() { // Print length of given string
        String msg = "Guvi geek";
        System.out.println(msg.length());
    }

    public static void Question8() { // Print Welcome to Guvi 10 times
        for(int i=0;i<10;i++){
            System.out.println("Welcome to GUVI");
        }
    }

    public static void Question9() { // To check senior citizen or not
        System.out.println("Enter age:");
        int age = myObj.nextInt();  // Read user input age
        if(age>=60){
            System.out.println("You are a senior citizen");
        }
        else System.out.println("You are not a senior citizen");
    }
    public static void Question10() { // Count number of digits in an integer
        System.out.println("Enter number:");
        int number = myObj.nextInt();  // Read user input age
        int count=0;
        while(number>0){
            number=number/10;
            count++;
        }
        System.out.println("The number digits in the given number is: "+ count);
    }
    public static void main(String[] args){
        Task8.Question1();
        Task8.Question2();
        Task8.Question3();
        Task8.Question4();
        Task8.Question5();
        Task8.Question6();
        Task8.Question7();
        Task8.Question8();
        Task8.Question9();
        Task8.Question10();
    }
}
