package com.metrot.demo.day2;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class FinalExamReview {
    public static void main(String[] args) {
        System.out.println("Welcome to Java II");

        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
        }

        System.out.println("Hello from the main method");

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from the for loop");
        }

        String num1 = "1"; //"one";
        int num2 = 0;
//        Write a try-catch statement that handles a NumberFormatException.
//                Inside the try block, parse num1 to an Integer and assign the result to num2.
//        Inside the catch block, print "'%s' is not a valid integer". Substitute %s with the value assigned to num1.
//        Outside the try-catch statement, cast num2 to a double and assign it to a variable called num3.
        try {
            num2 = Integer.parseInt(num1);
        } catch(NumberFormatException e) {
            System.out.printf("'%s' is not a valid integer\n", num1);
        }
        double num3 = num2;
        System.out.println(num3);


        // Assume a Mystery class exists with one instance variable called num.
        // Assume there is a parameterized constructor, getNum and setNum method.
        Mystery mystery1 = new Mystery(5);
        Mystery mystery2 = mystery1;
        mystery2.setNum(3);
        System.out.println(mystery1.getNum());
        //Tell me what prints and explain why.
        // mystery2 is a reference to object assigned to mystery1.
        // They both point to the same memory address
        // Changing one will change both


//        Write a for loop based on the following description.
//        Assign 0 to a sum variable before the loop. Start the loop count variable at 1.
//        The loop will continue while the sum is less than 50.
//        Each time the loop iterates, add 2 to the count variable.
//        Inside the loop, add the value of the count variable to the
//        sum variable and print the new sum. Don't print the sum if it is divisible by 3 or 5.
        // Prints: 1, 4, 16, 49, 64. Not print: 9, 25, 36.
        int sum = 0;
        for(int count = 1; sum < 50; count += 2) {
            sum += count;
            if (sum % 3 != 0 && sum % 5 != 0) {
                System.out.println(sum);
            }
        }

        // Write code to print the average of all integers in the following array
        // that are divisible by 3. Use a for-each loop for full credit.
        int[] arr = {12, 2, 9, 18, 10, 14, 6, 16};
        sum = 0;
        int count = 0;
        for (int num: arr) {
            if (num % 3 == 0) {
                sum += num;
                count++;
            }
        }
        System.out.println("Average is: " + (double)sum / count);

        //        Print the following message with double quotation marks included.

        System.out.println("I read \"Java: A Beginner's Guide\", by Herbert Schildt");


        // Write a Student class so this code works:
        Person student = new Student("Joe", 3.4);

        BankAccount account = new BankAccount(3499.99);
        System.out.println(account);

        // Describe how you call a static method.
        // You call static methods by typing a class name, a period, then the method name.
        // Example 1: LocalDate.now()
        // Example 2: DateTimeFormatter.ofPattern()

        // You call non-static methods by typing an object name, a period, then the method name.
        // Example 1: today.format()
        // Example 2: currencyFormat.format()










        System.out.println();

        double currencyAmount = 3500.00;
        Locale usa = new Locale("en", "US");
        Currency dollars = Currency.getInstance(usa);
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
        System.out.println(dollars.getDisplayName() + ": " + dollarFormat.format(currencyAmount));
    }
}
