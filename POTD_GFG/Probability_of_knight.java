package POTD_GFG;

//Probability_of_knight 

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    private double rec(int x, int y, int N, int step, double mem[][][]) {
        double count = 0;
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (mem[x][y][step] != 0)
                return mem[x][y][step];

            if (step == 0)
                return 1;

            count += rec(x - 2, y + 1, N, step - 1, mem);
            count += rec(x - 2, y - 1, N, step - 1, mem);
            count += rec(x - 1, y + 2, N, step - 1, mem);
            count += rec(x - 1, y - 2, N, step - 1, mem);
            count += rec(x + 1, y + 2, N, step - 1, mem);
            count += rec(x + 1, y - 2, N, step - 1, mem);
            count += rec(x + 2, y + 1, N, step - 1, mem);
            count += rec(x + 2, y - 1, N, step - 1, mem);

            mem[x][y][step] = count;
        }

        return count;

    }

    public double findProb(int N, int start_x, int start_y, int step) {
        double mem[][][] = new double[N][N][step + 1];

        double count = rec(start_x, start_y, N, step, mem);
        return count / Math.pow(8, step);
    }
}