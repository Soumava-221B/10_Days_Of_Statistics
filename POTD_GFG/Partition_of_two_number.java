package POTD_GFG;
//Partition_of_two_number 
    
//Initial Template for Java
import java.io.*;
import java.util.*;

class Partition_of_two_number {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().split(" ");
            String S = str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S, a, b));
        }
    }
}// } Driver Code Ends

// User function Template for Java
class Solution {
    static String stringPartition(String S, int a, int b) {

        for (int i = 1; i < S.length(); i++) {
            if ((Integer.parseInt(S.substring(0, i))) % a == 0 && (Integer.parseInt(S.substring(i))) % b == 0) {
                return String.format(S.substring(0, i) + " " + S.substring(i));
            }
        }
        return "-1";
    }
}