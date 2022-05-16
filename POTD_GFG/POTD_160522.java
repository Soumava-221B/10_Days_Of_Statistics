package POTD_GFG;

//POTD_160522 

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {

        int maxl = 0, cursum = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cursum += a[i];
            int r = cursum % k;
            if (r < 0)
                r = r + k;
            if (r == 0)
                maxl = Math.max(maxl, i + 1);
            if (!m.containsKey(r))
                m.put(r, i);
            else
                maxl = Math.max(maxl, i - m.get(r));
        }
        return maxl;
    }

}

// { Driver Code Starts.

// Driver class
class GFG {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] element = line1.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();

            int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);

            System.out.println(res);

        }
    }
}
