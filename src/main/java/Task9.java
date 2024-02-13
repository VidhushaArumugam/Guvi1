import java.util.Scanner;

public class Task9 {
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    public static void Question1() { //Palindrome
        System.out.println("Enter string:");
        String a = myObj.nextLine();  // Read user input a
        int stringLen = a.length();   //Finding length of string
        a=a.toUpperCase();          //converting to uniform case
        String reverse = "";        //initialising the reverse string
        for (int i = stringLen-1;i>=0;i--){
            reverse= reverse+a.charAt(i);          //storing the characters in reverse order
        }
        if (a.equals(reverse)){
            System.out.println("The string is palindrome");    //if both same, printing palindrome
        }
        else{
            System.out.println("The string is not palindrome");  //if both not same, printing not palindrome
        }

    }
    public static void Question2() { //Reverse String
        System.out.println("Enter string:");
        String a = myObj.nextLine();  // Read user input a
        int stringLen = a.length();   //Finding length of string
        String reverse = "";          //initialising the reverse string
        for (int i = stringLen-1;i>=0;i--){
            reverse= reverse+a.charAt(i);    //storing the characters in reverse order
        }
        System.out.println(reverse);     //Printing reversed string

    }

    public static void Question3() { //Print left number pattern
        int i, j, k = 1;
        System.out.println("Enter number(n):");
        int n = myObj.nextInt();  // Read user input n
        for (i = 1; i <= n; i++)        //outer loop to manage the number of rows
        {
            for (j = 1; j< i + 1; j++)   //inner loop to print numbers
            {
                System.out.print(k++ + " ");    //printing numbers
            }
            System.out.println();  //moving to next row
        }

    }

    public static void Question4() { //Sandglass star pattern based on input rows given
        System.out.print("Enter the number of rows you want to print: ");
        int n = myObj.nextInt();   //getting the no of rows
        int i,j,k;                 //declaring variable for loop
        for (i= 1; i<= n ; i++)     //outer loop to iterate based on the input rows given
        {
            for (j=1; j<i; j++)     //Printing space if j<i
            {
                System.out.print(" ");
            }
            for (k=i; k<=n; k++)   //printing stars based on the k,n value
            {
                System.out.print("* ");
            }
            System.out.println();  //going to next line after inner loop command finish
        }
        for (i= n-1; i>= 1; i--)    //decrementing the triangle by decrementing i--
        {
            for (j=1; j<i; j++)     //Printing space if j<i
            {
                System.out.print(" ");
            }
            for (k=i; k<=n; k++)  //printing stars based on the n value
            {
                System.out.print("* "); //printing stars based on the k,n value
            }
            System.out.println();   //going to next line after inner loop command finish
        }

    }
    public static void Question5(){ //Grading system
        System.out.print("Enter your marks: ");
        int marks = myObj.nextInt();  //getting user marks
        if(marks==100){     //validating for different user marks using if statement
            System.out.println("Your Grade is S");
        }
        else if(marks>89 && marks<100){
            System.out.println("Your Grade is A");
        }
        else if(marks>79 && marks<90){
            System.out.println("Your Grade is B");
        }
        else if(marks>69 && marks<80){
            System.out.println("Your Grade is C");
        }
        else if(marks>59 && marks<70){
            System.out.println("Your Grade is D");
        }
        else if(marks>49 && marks<60){
            System.out.println("Your Grade is E");
        }
        else if(marks<50){
            System.out.println("Your Grade is F");
        }
        else {
            System.out.println("You entered invalid marks");
        }

    }
    public static void Question6() { //Hotel Tarrif
        System.out.print("Enter the month of stay(in number): ");
        int month = myObj.nextInt();   //Getting input month
        System.out.print("Enter the rent: ");
        float rent = myObj.nextFloat();   //Getting input rent in float
        System.out.print("Enter the days of stay: ");
        float days = myObj.nextFloat();  //Getting input days in float
        switch (month) {   //switching based on month
            case 1, 2, 3, 7, 8, 9, 10:
                float TotalTarrif1 = rent * days;   //Tarrif calculation
                System.out.printf("The hotel tariff for you is: %.2f " , TotalTarrif1);  //Printing as float with 2 decimal places
                break;
            case 4, 5, 6, 11, 12:
                rent = rent + (rent / 5);    //20% hike rent
                float TotalTarrif2 = rent * days;   //Tarrif calculation
                System.out.printf("The hotel tariff for you is: %.2f" , TotalTarrif2); //Printing as float with 2 decimal places
                break;
        }
    }

    public static void Question7() { //Calculate largest among 3 numbers
        System.out.print("Enter the Number 1: ");
        int num1 = myObj.nextInt();    //Getting input number 1
        System.out.print("Enter the Number 2: ");
        int num2 = myObj.nextInt();    //Getting input number 2
        System.out.print("Enter the Number 3: ");
        int num3 = myObj.nextInt();   //Getting input number 3
        if(num1>num2 && num1>num3){   //Checking if num1 is largest
            System.out.println("Number 1 "+num1+ " is greatest number");
        }
        else if(num2>num1 && num2>num3){  //Checking if num2 is largest
            System.out.println("Number 2 "+num2+ " is greatest number");
        }
        else {  //else printing num3 is largest
            System.out.println("Number 3 "+num3+ " is greatest number");
        }


    }
        public static void main (String[] args) { //calling all answers using methods
            Task9.Question1();
            Task9.Question2();
            Task9.Question3();
            Task9.Question4();
            Task9.Question5();
            Task9.Question6();
            Task9.Question7();

        }
    }
