package POTD_GFG;

import java.util.*;
import java.lang.*;
import java.io.*;

class POTD_150522 {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.print("()");
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        Arrays.sort(arr);
        
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        subset(0, arr.length, arr, al, res);
        res.remove(0);
        
        return res;
    }
    
    static void subset(int st, int n, int[]arr, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<>(al));
        
        for(int i=st; i<n; i++){
            if(i>st && arr[i]==arr[i-1]){
                continue;
            }
            
            al.add(arr[i]);
            subset(i+1, n, arr, al, res);
            al.remove(al.size()-1);
        }
}
}
