
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.brainGame(nums);
            if(ans)
                System.out.println("A");
            else 
                System.out.println("B");     
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean brainGame(int[] nums)
    {
        
        int chances=0;
       for(int e: nums){
           chances^=primefactors(e);
       }
       return chances!=0;
    }
    
    public boolean isPrime(int n){
       if (n <= 1)
           return false;
       else if (n == 2)
           return true;
       else if (n % 2 == 0)
           return false;
       for (int i = 3; i <= Math.sqrt(n); i += 2){
           if (n % i == 0)
               return false;
       }
       return true;
   }
   public int nextPrime(int e){
       if(e==2) return 3;
       do{
           e+=1;
       }while(!isPrime(e));
       return e;
   }
   public int primefactors(int e){
       if(isPrime(e)||e==1)return 0;
       int k=2;
       int count=0;
       while(e!=1){
           while(e%k==0){
               e/=k;
               count++;
           }
           k=nextPrime(k);
       }
       return count-1;
   }
}