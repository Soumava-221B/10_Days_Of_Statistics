// Objective 
//In this challenge,we learn about binomial distributions.Check out the Tutorial tab for learning materials!

// Task 
//The ratio of boys to girls for babies born in Russia is 1.09.If there is 1 child born per birth,what proportion of Russian families with exactly 6 children will have at least 3 boys?

// Write a program to compute the answer using the above parameters.Then print your result,rounded to a scale of 3 decimal places(i.e., 1.234format).

// Input Format

// A single line containing the following values:

// 1.09 

//1 If you do not wish to read this information from stdin,you can hard-code it into your program.

// Output Format

// Print a single line denoting the answer,rounded to a scale of decimal places(i.e., 1.234format).

package src;

//Day_4_Binomial1 

import java.util.Scanner;

public class Day_4_Binomial1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double r = kb.nextDouble();
        double c = kb.nextDouble();
        double b = r / (r + c);
        int x = 6;
        double prob = 0;
        for (int i = 3; i <= x; i++)
            prob += Math.pow(b, i) * Math.pow(1 - b, x - i) / (f(i) * f(x - i));
        System.out.printf("%.3f", f(x) * prob);
        kb.close();
    }

    public static int f(int n) {
        return n == 0 ? 1 : n * f(n - 1);
    }
}