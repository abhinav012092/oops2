package linkedlists;
import java.util.*;
public class double_LL_2sum_pair {
	public static Scanner sc=new Scanner(System.in);
	public static class Node {
		int val=0;
		Node next=null;
		Node back=null;
		Node(int val){
			this.val=val;
			this.next=null;
			this.back=null;
		}
		Node(int val, Node next, Node back){
			this.val=val;
			this.next=next;
			this.back=back;
		}
	}
	public static int[][] sum_pair(Node head,int n, int sum) {
		int[][] arr=new int[n/2+1][2];
		Node tail=head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		Node left=head;
		Node right=tail;
		int i=0;
		while(left.val<=right.val&&i<arr.length) {
			if(left.val+right.val==sum) {
				arr[i][0]=left.val;
				arr[i][1]=right.val;
				right=right.back;
				left=left.next;
			} else if(left.val+right.val<sum) {
				left=left.next;
			} else {
				right=right.back;
			}
			i++;
		}
		return arr;
	}
	public static Node createList(int n) {
		Node dummy=new Node((int)1e8);
		Node prev=dummy;
		while(n-- >0) {
			Node temp=new Node(sc.nextInt(),null,prev);
			prev.next=temp;
			prev=prev.next;
		}
		Node head=dummy.next;
		head.back=null;
		return head;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.val+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		Node dll=createList(n);
		int[][] res=sum_pair(dll,n,5);
		for(int i=1;i<res.length;i++) {
			System.out.println(res[i][0]+","+res[i][1]);
		}
	}
}
