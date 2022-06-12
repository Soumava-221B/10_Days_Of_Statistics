//POTD_100622 

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);

            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");

            int[] A = new int[N];
            int[] B = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A, B, T, N));
        }
    }
}// } Driver Code Ends

class Solution {

    public static class Pair implements Comparable<Pair> {
        int coins;
        int plates;

        Pair(int coins, int plates) {
            this.coins = coins;
            this.plates = plates;
        }

        int getCoins() {
            return this.coins;
        }

        int getPlates() {
            return this.plates;
        }

        public int compareTo(Pair o) {
            return o.coins - this.coins;
        }

    }

    static int maxCoins(int[] A, int[] B, int T, int N) {

        Queue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Pair(B[i], A[i]));
        }

        int res = 0;
        while (T > 0 && pq.size() > 0) {
            int coins = pq.peek().getCoins();
            int plates = pq.peek().getPlates();
            res = res + coins * Math.min(T, plates);
            T = T - Math.min(T, plates);
            pq.poll();

        }
        return res;

    }
}