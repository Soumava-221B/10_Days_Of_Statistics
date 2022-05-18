package POTD_GFG;

//POTD_180522

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);

            for (int i = 0; i < ans.size(); i++) {
                System.out.print("(" + ans.get(i) + ")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    ArrayList<String> permutation(String S) {

        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        helper(0, arr, S, str);
        return arr;
    }

    public static void helper(int val, ArrayList<String> arr, String S, String str) {
        if (val == S.length()) {
            arr.add(str);
            return;
        }
        if (val != 0)
            helper(val + 1, arr, S, str + " " + S.charAt(val));
        helper(val + 1, arr, S, str + S.charAt(val));
    }
}