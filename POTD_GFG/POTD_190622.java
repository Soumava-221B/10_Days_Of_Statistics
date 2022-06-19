//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    
    public static Node reverseBetween(Node head, int m, int n)
    {
        
        Node dummy = new Node(-1);
       dummy.next = head;
       
       Node prevToStart = dummy;
       
       Node prev = dummy;
       Node start=null;
       Node nxt = null;
       
       int count=0;
       while(head != null){
           count++;
           
           if(count==m){
               prevToStart = prev;
               start = head;
           }
           if(count==n){
               nxt = head.next;
               reverse(start, head);
               prevToStart.next = head;
               start.next = nxt;
               break;
           }
           
           prev = head;
           head = head.next;
       }
       return dummy.next;
    }
    
    public static void reverse(Node start, Node end){
       Node prev = null;
       Node nxt = start.next;
       while(prev != end){
           start.next = prev;
           prev = start;
           start = nxt;
           if(nxt != null){
               nxt = nxt.next; 
           }
       }
}

}