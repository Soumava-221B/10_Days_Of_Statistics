//POTD_230522 

//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);

            if (res.length == 0)
                System.out.println("No Ordering Possible");
            else {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static HashMap<Integer, Integer> fillmap(ArrayList<ArrayList<Integer>> prerequisites) {
        // for each prerequisites pair create a weighted value for each time a course
        // needs to be completed
        HashMap<Integer, Integer> completed = new HashMap<>();
        for (ArrayList<Integer> pairs : prerequisites) {
            if (completed.get(pairs.get(0)) == null) {
                completed.put(pairs.get(0), 1);
            } else {
                completed.put(pairs.get(0), completed.get(pairs.get(0)) + 1);
            }
        }
        return completed;
    }

    static HashMap<Integer, ArrayList<Integer>> fillmap2(ArrayList<ArrayList<Integer>> prerequisites) {
        // for each prerequisite create a graph o who should access the prerequisite ie:
        // the reverse arcs of the prerequisite
        HashMap<Integer, ArrayList<Integer>> completed = new HashMap<>();
        for (ArrayList<Integer> pairs : prerequisites) {
            if (completed.get(pairs.get(1)) == null) {
                ArrayList<Integer> children = new ArrayList<Integer>();
                children.add(pairs.get(0));
                completed.put(pairs.get(1), children);
            } else {
                completed.get(pairs.get(1)).add(pairs.get(0));
            }
        }
        return completed;
    }

    static void bfs(HashMap<Integer, Integer> completed, HashMap<Integer, ArrayList<Integer>> graph,
            ArrayList<Integer> sol, int init) {

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(init);
        while (!q.isEmpty()) {
            int node = q.poll();
            sol.add(node);
            ArrayList<Integer> children = graph.get(node);
            if (children != null) {
                for (int child : children) {
                    if (completed.get(child) != null) {
                        completed.put(child, completed.get(child) - 1);
                        if (completed.get(child) == 0 && !sol.contains(child)) {
                            q.add(child);
                        }
                    }
                }
            }
        }

    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {

        HashMap<Integer, Integer> completed = fillmap(prerequisites);
        HashMap<Integer, ArrayList<Integer>> graph = fillmap2(prerequisites);

        ArrayList<Integer> sol = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (completed.get(i) == null) {
                bfs(completed, graph, sol, i);
            }

        }

        int[] arr = {};

        if (sol.size() == n) {
            arr = sol.stream().mapToInt(i -> i).toArray();
        }

        return arr;
    }
}