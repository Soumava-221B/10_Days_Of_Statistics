import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static boolean rec(int ind, int arr[], int N, Boolean dp[])
    {
        if(ind>=N-1) return true;
        
        if(dp[ind]!=null) return dp[ind];
        
        if(arr[ind]==0) return dp[ind] = new Boolean(false);
        
        for(int i=1; i<=arr[ind]; i++)
        {
            if(rec(ind+i, arr, N, dp))
            {
                dp[ind] = new Boolean(true);
                return true;
            }
        }
        
        return dp[ind] = new Boolean(false);
        
        
        
    }
    
    static int canReach(int[] A, int N) {
        
        boolean dp[] = new boolean[N];
        
        dp[N-1] = true;
        
        for(int i=N-2; i>=0; i--)
        {
            if(A[i]==0) continue;
            
            for(int j=1; j<=A[i]; j++)
            {
                if(i+j>=N) break;
                else if(dp[j+i])
                {
                    dp[i] = true;
                    break;
                }
            }
            
        }
        
        
        return dp[0] ? 1 : 0;
    }
};