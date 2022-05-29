package POTD_GFG;

//Shortest_Path 

//Initial Template for Java

import java.io.*;
import java.util.*;

class Shortest_Path {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int x = Integer.parseInt(input_line[0]);
            int y = Integer.parseInt(input_line[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestPath(x, y));
        }
    }
} // } Driver Code Ends

// User function Template for Java

class Solution {
    int shortestPath(int x, int y) {
        int div1 = Math.max(x, y);
        int div2 = Math.min(x, y);
        int parent = -1;
        int dist = 0;
        while (true) {
            while (div1 > div2) {
                div1 /= 2;
                dist++;
            }
            while (div2 > div1) {
                div2 /= 2;
                dist++;
            }
            if (div2 == div1) {
                parent = div2;
                break;
            }
        }
        return dist;
    }
}