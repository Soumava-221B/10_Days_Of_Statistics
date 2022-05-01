package POTD_GFG;

// A prime number is Super Prime if it is a sum of two primes.Find all the Super Primes upto N

// Example 1:

// Input:
// N = 5
// Output: 1
// Explanation: 5 = 2 + 3, 5 is the
// only super prime

// Example 2:

// Input:
// N = 10 
// Output: 2
// Explanation: 5 and 7 are super primes

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function superPrimes() which takes the N as input and returns the count of super primes.

// Expected Time Complexity: O(Nlog(logN))
// Expected Auxiliary Space: O(N)

// Constraints:
// 1 ≤ N ≤ 105

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.superPrimes(n));
        }
    }
} // Driver code Ends

//User Function Template for Java

class Solution {

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    int superPrimes(int n) {

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i - 2) && isPrime(i))
                count++;
        }

        return count;
    }
}