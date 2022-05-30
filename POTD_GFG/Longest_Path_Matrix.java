package POTD_GFG;

//Longest_Path_Matrix 

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Longest_Path_Matrix
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    
    private static int rec(int i, int j, int matrix[][], int n, int m, int dp[][])
    {
        if(dp[i][j]!=0) return dp[i][j];
        
        int max_len_path = 1;
        
        for(int k=0; k<4; k++)
        {
            int x = i + dx[k];
            int y = j + dy[k];
            
            if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]>matrix[i][j])
            {
                max_len_path = Math.max(max_len_path, 1 + rec(x, y, matrix, n, m, dp));
            }
            
        }
        
        return dp[i][j] = max_len_path;
        
    }
    
    public int longestIncreasingPath(int[][] matrix)
    {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][] = new int [n][m];
        
        int ans = 0;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                ans = Math.max(ans, rec(i, j, matrix, n, m, dp));
            }
            
        }
        
        return ans;
        
    }
}