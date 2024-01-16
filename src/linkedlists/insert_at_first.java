package linkedlists;
import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
	ListNode(int val, ListNode next){
		this.val=val;
		this.next=next;
	}
}

public class insert_at_first {
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"-->");
			head=head.next;
		}
		System.out.println("null");
	}
	
	public static ListNode insertFirst(int val, ListNode head) {
		ListNode newNode=new ListNode(val);
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=null;
		head=insertFirst(40,head);
		head=insertFirst(30,head);
		head=insertFirst(20,head);
		head=insertFirst(10,head);
		System.out.println("LinkedList before inserting 0 at beginning");
		printList(head);
		head=insertFirst(0,head);
		System.out.println("LinkedList after inserting 0 at beginning");
		printList(head);
	}
}