//POTD_010722 


//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.FindNthTerm(n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    long mod = (long) 1e9 + 7;

    void multiply(long arr[][], long arr1[][]) {
        long ans[][] = new long[2][2];
        long x = (arr[0][0] % mod * arr1[0][0] % mod + arr[0][1] % mod * arr1[1][0] % mod) % mod;
        long y = (arr[0][0] % mod * arr1[0][1] % mod + arr[0][1] % mod * arr1[1][1] % mod) % mod;
        long z = (arr[1][0] % mod * arr1[0][0] % mod + arr[1][1] % mod * arr1[1][0] % mod) % mod;
        long w = (arr[1][0] % mod * arr1[0][1] % mod + arr[1][1] % mod * arr1[1][1] % mod) % mod;
        arr[0][0] = x % mod;
        arr[0][1] = y % mod;
        arr[1][0] = z % mod;
        arr[1][1] = w % mod;

    }

    void solve(long arr[][], int n) {
        if (n == 0 || n == 1)
            return;
        long f[][] = new long[][] { { 1, 1 }, { 1, 0 } };
        solve(arr, n / 2);
        multiply(arr, arr);
        if (n % 2 == 1)
            multiply(arr, f);
    }

    public int FindNthTerm(int n) {

        long arr[][] = new long[][] { { 1, 1 }, { 1, 0 } };
        if (n == 0)
            return 0;
        solve(arr, n);
        return (int) arr[0][0];
    }
}