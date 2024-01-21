package linkedlists;
import java.util.*;

public class double_LL_reverse {
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
	public static Node reverse(Node head) {
		if(head==null||head.next==null) return head;
		Node prev=null;
		Node curr=head;
		while(curr!=null) {
			prev=curr.back;
			curr.back=curr.next;
			curr.next=prev;
			curr=curr.back;
		}
		return prev.back;
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
		Node dummy=new Node((int)1e8);
		Node mover=dummy;
		while(n-- >0) {
			Node temp=new Node(sc.nextInt(),null,mover);
			mover.next=temp;
			mover=mover.next;
		}
		Node head=dummy.next;
		Node dll=reverse(head);
		printList(dll);
	}

}
