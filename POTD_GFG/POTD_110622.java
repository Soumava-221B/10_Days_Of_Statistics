//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            double a[] = new double[(int)(n)];
            double getAnswer[] = new double[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Double.parseDouble(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.nullPoints(n, a, getAnswer); 
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n-1;i++)
                output.append(String.format("%.2f", getAnswer[i])+" ");
                
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static double getSum(int low, int high, double eq, double magnets[])
    {
        double sum = 0.0;
        
        for(int i=low; i<high; i++)
        {
            sum += 1/(Math.abs(eq-magnets[i]));
        }
        
        
        return sum;
        
        
    }
    
    private static double findEquiPoint(int sp, double magnets[], int n)
    {
        double left = magnets[sp-1];
        double right = magnets[sp];
        // System.out.println((left+right)/2);
        while(left<=right)
        {
            
            double eq = (left+right)/2;
            
            double lsum = getSum(0, sp, eq, magnets);
            double rsum = getSum(sp, n, eq, magnets);
            
            
            if(Math.abs(rsum-lsum)<0.000001) return eq;
            
            else if(lsum>rsum)
            {
                left = eq;
            }
            else
            {
                right = eq;
            }
            
        }
        
        return (right+left)/2;
        
        
    }
    
    public void nullPoints(int n, double magnets[], double getAnswer[])
    {
        
        for(int i=1; i<n; i++)
        {
            getAnswer[i-1] = findEquiPoint(i, magnets,  n);
        }
    }
}


