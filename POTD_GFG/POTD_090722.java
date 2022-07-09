//POTD_090722 

import java.util.Scanner;
import java.io.*;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int a, int b) {
        coeff = a;
        pow = b;
        next = null;
    }
}

class GFG2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node start1 = null, cur1 = null, start2 = null, cur2 = null;
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node ptr = new Node(a, b);
                if (start1 == null) {
                    start1 = ptr;
                    cur1 = ptr;
                } else {
                    cur1.next = ptr;
                    cur1 = ptr;
                }
            }
            n = sc.nextInt();
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node ptr = new Node(a, b);
                if (start2 == null) {
                    start2 = ptr;
                    cur2 = ptr;
                } else {
                    cur2.next = ptr;
                    cur2 = ptr;
                }
            }
            Solution obj = new Solution();
            Node sum = obj.addPolynomial(start1, start2);
            for (Node ptr = sum; ptr != null; ptr = ptr.next) {
                // printing polynomial
                System.out.print(ptr.coeff + "x^" + ptr.pow);
                if (ptr.next != null)
                    System.out.print(" + ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * class Node{
 * int coeff;
 * int pow;
 * Node next;
 * Node(int a,int b)
 * {
 * coeff=a;
 * pow=b;
 * next=null;
 * }
 * }
 */

// Print the polynomial formed by adding both LL in the function itself.
class Solution {
    public static Node addPolynomial(Node p1, Node p2) {

        Node i = p1;
        Node j = p2;
        Node k = new Node(0, 0);
        Node ans = k;

        while (i != null && j != null) {
            if (i.pow == j.pow) {
                k.next = new Node(i.coeff + j.coeff, i.pow);
                k = k.next;
                i = i.next;
                j = j.next;
            } else if (i.pow > j.pow) {
                k.next = new Node(i.coeff, i.pow);
                k = k.next;
                i = i.next;
            } else if (i.pow < j.pow) {
                k.next = new Node(j.coeff, j.pow);
                k = k.next;
                j = j.next;
            }

        }

        while (i != null) {
            k.next = new Node(i.coeff, i.pow);
            k = k.next;
            i = i.next;
        }

        while (j != null) {
            k.next = new Node(j.coeff, j.pow);
            k = k.next;
            j = j.next;
        }

        return ans.next;
    }
}