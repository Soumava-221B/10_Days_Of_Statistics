package POTD_GFG;


import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);

            // calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to return the largest possible number of n digits
    // with sum equal to given sum.
    static String largestNumber(int n, int sum) {

        if (9 * n < sum)
            return "-1";
        int a = sum / 9;
        String res = "";
        for (int i = 0; i < a; i++)
            res = res + "9";
        int r = sum % 9;
        if (r != 0)
            res = res + r;
        while (res.length() < n)
            res = res + "0";
        return res;
    }
}
