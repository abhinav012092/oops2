package linkedlists;
import java.util.*;

public class double_LL_remove_dup {
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
	public static Node remove_dup(Node head) {
		Node temp=new Node(-1);
		Node newHead=temp;
		Node curr=head;
		while(curr!=null) {
			while(curr!=null&&temp.val==curr.val) {
				curr=curr.next;
			}
			temp.next=curr;
			curr.back=temp;
			temp=temp.next;
			if(curr!=null) {
				curr=curr.next;
			}
		}
		return newHead.next;
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
		Node res=remove_dup(dll);
		printList(res);
	}

}
