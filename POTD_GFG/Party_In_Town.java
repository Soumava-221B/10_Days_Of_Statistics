import java.io.*;
import java.util.*;

class Party_In_Town {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < N + 1; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                adj.add(arr);
            }
            for (int i = 0; i < N - 1; i++) {
                String a[] = in.readLine().trim().split("\\s+");
                int x = Integer.parseInt(a[0]);
                int y = Integer.parseInt(a[1]);
                adj.get(x).add(y);
                adj.get(y).add(x);
            }

            Solution ob = new Solution();
            System.out.println(ob.partyHouse(N, adj));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    private static boolean[] visited;

    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj) {

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            ans = Math.min(ans, dfs(adj, i));
        }

        return ans;
    }

    private static int dfs(ArrayList<ArrayList<Integer>> adj, int s) {
        visited[s] = true;

        int temp = 0;
        for (int adjacent : adj.get(s)) {
            if (!visited[adjacent]) {
                temp = Math.max(temp, 1 + dfs(adj, adjacent));
            }
        }

        return temp;
    }
}