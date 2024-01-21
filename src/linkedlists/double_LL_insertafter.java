package linkedlists;
import java.util.*;
public class double_LL_insertafter {
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
	public static Node insertAfterHead(Node head,int val) {
		if(head==null) return new Node(val);
		if(head.next==null) {
			Node second = new Node(val,null,head);
			head.next=second;
			return head;
		}
		Node temp=new Node(val,head.next,head);
		Node front=head.next;
		front.back=temp;
		head.next=temp;
		return head;
	}
	public static Node addAfterTail(Node head, int val) {
		Node tail=head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		tail.next=new Node(val,null,tail);
		return head;
	}
	public static void insertAfterNode(Node node, int val) {
		Node front=node.next;
		Node newNode=new Node(val,front,node);
		front.back=newNode;
		node.next=newNode;
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
		Node prev=dummy;
		while(n-- >0) {
			Node temp=new Node(sc.nextInt(),null,prev);
			prev.next=temp;
			prev=prev.next;
		}
		Node head=dummy.next;
		Node dll=insertAfterHead(head,4);
		dll=addAfterTail(dll,10);
		insertAfterNode(dll.next,100);
		printList(dll);
	}

}
