//POTD_220522 

import java.io.*;
import java.util.*;

class POTD_220522 {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            int Q = Integer.parseInt(read.readLine());

            int[] index = new int[Q];
            String[] sources = new String[Q];
            String[] targets = new String[Q];

            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            String S3[] = read.readLine().split(" ");

            for (int i = 0; i < Q; i++) {
                index[i] = Integer.parseInt(S1[i]);
                sources[i] = S2[i];
                targets[i] = S3[i];
            }

            Solution ob = new Solution();
            System.out.println(ob.findAndReplace(S, Q, index, sources, targets));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    private static boolean strMatch(int st, String S, String X) {
        int i = st;
        int n = S.length();
        int j = 0;
        int m = X.length();

        while (i < n && j < m) {
            if (S.charAt(i) == X.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        if (j == m)
            return true;

        return false;

    }

    static String findAndReplace(String S, int Q, int[] index, String[] sources, String[] targets) {

        HashMap<Integer, Integer> valid = new HashMap<>();

        for (int i = 0; i < Q; i++) {
            if (strMatch(index[i], S, sources[i])) {
                valid.put(index[i], i);
            }
        }

        StringBuilder ans = new StringBuilder();

        int n = S.length();

        int i = 0;

        while (i < n) {
            if (valid.containsKey(i)) {
                int ind = valid.get(i);
                String tgt = targets[ind];
                ans.append(tgt);

                i += sources[ind].length();
            } else {
                ans.append(S.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
};