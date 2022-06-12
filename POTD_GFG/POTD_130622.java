//POTD_130622
// String Formation from substring
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private void getFactor(int n,List<Integer> fact){
	for(int i=1;i<=n/2;i++){
		if(n%i==0)
			fact.add(i);
	 }
    }
    
    int isRepeat(String s) {
        
        int n=s.length();
    List<Integer> fact=new ArrayList();
    getFactor(n,fact);
    for(int i=0;i<fact.size();i++){
        String sub=s.substring(0,fact.get(i));
        boolean flag=true;
        for(int j=fact.get(i);j<n;j+=fact.get(i)){
            if(!sub.equals(s.substring(j,j+fact.get(i)))){
                flag=false;
                break;
            }
        }
        if(flag)
            return 1;
    }
    return 0;
    }
}