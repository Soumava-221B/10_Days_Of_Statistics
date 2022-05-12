package POTD_GFG;

//POTD_120522 

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Solution {

    boolean isPossible(int i, int j, int[][] arr, int[][] vis) {
        if (arr[i][j] == 2)
            return true;
        boolean up = false, down = false, left = false, right = false;
        if ((i - 1) >= 0 && vis[i - 1][j] != 1 && arr[i - 1][j] != 0) {
            vis[i - 1][j] = 1;
            up = isPossible(i - 1, j, arr, vis);
        }
        if ((i + 1) < arr.length && vis[i + 1][j] != 1 && arr[i + 1][j] != 0) {
            vis[i + 1][j] = 1;
            down = isPossible(i + 1, j, arr, vis);
        }
        if ((j - 1) >= 0 && vis[i][j - 1] != 1 && arr[i][j - 1] != 0) {
            vis[i][j - 1] = 1;
            left = isPossible(i, j - 1, arr, vis);
        }
        if ((j + 1) < arr.length && vis[i][j + 1] != 1 && arr[i][j + 1] != 0) {
            vis[i][j + 1] = 1;
            right = isPossible(i, j + 1, arr, vis);
        }

        return (up || down || left || right);

    }

    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {

        int n = grid.length;
        int[][] vis = new int[n][n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        vis[x][y] = 1;
        return isPossible(x, y, grid, vis);
    }
}