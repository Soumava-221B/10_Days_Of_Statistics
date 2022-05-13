package POTD_GFG;
//POTD_130522 {=
    
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class POTD_130522 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {

        Set<Integer> result = new LinkedHashSet<>();
        Integer[] allElem = new Integer[n * 2];
        int c = 0;
        for (int i = 0; i < n; i++) {
            allElem[c] = arr2[i];
            allElem[c + 1] = arr1[i];
            c += 2;
        }
        Arrays.sort(allElem, Collections.reverseOrder());
        Set<Integer> set = new LinkedHashSet<>();
        // n unique largest elements from both arrays.
        for (Integer num : allElem) {
            set.add(num);
            if (set.size() == n)
                break;
        }

        // serch for their actual position in array.
        for (int x : arr2) {
            if (set.contains(x)) {
                result.add(x);
                set.remove(x);
            }
        }
        for (int x : arr1) {
            if (set.contains(x)) {
                result.add(x);
            }
        }
        return new ArrayList<Integer>(result);
    }
}