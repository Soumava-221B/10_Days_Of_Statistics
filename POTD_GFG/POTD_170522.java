package POTD_GFG;

//POTD_170522 

import java.io.*;
import java.lang.*;
import java.util.*;

class Array {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution().minNumber(arr, 0, n - 1));
        }
    }

}// } Driver Code Ends

class Solution {
    // Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high) {

        int n = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            // System.out.println(mid);

            int x = arr[low];
            int m = arr[mid];
            int y = arr[high];

            int n1 = mid - 1 >= 0 ? arr[mid - 1] : Integer.MAX_VALUE;
            int n2 = mid + 1 < n ? arr[mid + 1] : Integer.MAX_VALUE;

            if (n1 > m && m < n2)
                return m;

            if (x > y) {
                if (m < y)
                    high = mid - 1; // It is on the left side.
                else
                    low = mid + 1; // It is on the right side.
            } else {
                high = mid - 1; // It is surely on the left side.
            }
        }

        return -1;
    }
}