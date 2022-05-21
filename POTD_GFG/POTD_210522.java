//POTD_210522 

import java.io.*;
import java.util.*;

class POTD_210522 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] Arr = new int[N];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < N; i++) {
                Arr[i] = Integer.parseInt(strs[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.farNumber(N, Arr);

            for (int i = 0; i < ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int[] farNumber(int N, int Arr[]) {

        int a[] = new int[N];
        a[N - 1] = -1;
        int flag = 0;
        for (int i = 0; i < N; i++) {
            int j = N - 1;
            while (j > i) {
                if (Arr[i] > Arr[j]) {
                    a[i] = j;
                    break;
                } else
                    a[i] = -1;
                j--;
            }
            flag = 0;
        }
        return a;
    }
}