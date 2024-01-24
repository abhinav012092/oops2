package linkedlists;
import java.util.*;
public class double_LL_rotate {
	public static Scanner sc=new Scanner(System.in);
	public static class Node {
		int data=0;
		Node next=null;
		Node back=null;
		Node(int data){
			this.data=data;
			this.next=null;
			this.back=null;
		}
		Node(int data, Node next, Node back){
			this.data=data;
			this.next=next;
			this.back=back;
		}
	}
	public static Node rotatedll(Node head, int k) {
		Node tail=head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		tail.next=head;
		head.back=tail;
		for(int i=0;i<k;i++) {
			head=head.next;
		}
		Node temp=head.back;
		head.back=null;
		temp.next=null;
		return head;
	}
	public static Node createList(int n) {
		Node dummy=new Node((int)1e8);
		Node prev=dummy;
		while(n-- >0) {
			Node temp=new Node(sc.nextInt(),null,prev);
			prev.next=temp;
			prev=temp;
		}
		Node head=dummy.next;
		head.back=null;
		return head;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		Node dll=createList(n);
		Node res=rotatedll(dll,3);
		printList(res);
	}

}
