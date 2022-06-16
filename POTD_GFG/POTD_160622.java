//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean check(int array1[],int array2[]){
        for(int i=0;i<60;i++){
            if(array1[i]>0 && array2[i]<=0){
                return false;
            }
        }
        
        return true;
    }
    
    public int findSubString( String str) {
        
        int fre1[]=new int[60];
        int fre2[]=new int[60];
        
        for(char c:str.toCharArray()){
            fre1[c-'A']++;
        }
        
        int i=0;
        int result=Integer.MAX_VALUE;
        int current=0;
        
        for(int j=0;j<str.length();j++){
            fre2[str.charAt(j)-'A']++;
            
            while(check(fre1,fre2)){
                current=j-i+1;
                result=Math.min(result,current);
                fre2[str.charAt(i)-'A']--;
                i++;
            }
        }
        
        return result;
    }
}