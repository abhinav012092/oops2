package linkedlists;
import java.util.*;

public class delete_key {
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
		Node(int val, Node next,Node back){
			this.val=val;
			this.next=next;
			this.back=back;
		}
	}
	public static Node deleteKey(Node head,int key) {
		Node temp=head;
		while(temp!=null) {
			if(temp.val==key) {
				if(temp==head) {
					head=head.next;
				}
				Node nextNode=temp.next;
				Node prevNode=temp.back;
				if(nextNode!=null) nextNode.back=prevNode;
				if(prevNode!=null) prevNode.next=nextNode;
				temp=nextNode;
			} else {
				temp=temp.next;
			}
		}
		return head;
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
		Node head=createList(n);
		Node dll=deleteKey(head,10);
		printList(dll);
	}

}
