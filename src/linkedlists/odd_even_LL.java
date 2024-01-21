package linkedlists;
import java.util.*;

import linkedlists.length_of_loop_ll.ListNode;

public class odd_even_LL {
	public static Scanner sc = new Scanner(System.in);
	
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode(int val){
			this.val=val;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	
	public static ListNode oddEven(ListNode head) {
		ListNode odd=head;
		ListNode even=head.next;
		ListNode temp=head.next;
		while(even!=null&& even.next!=null) {
			odd.next=odd.next.next;
			odd=odd.next;
			even.next=even.next.next;
			even=even.next;
		}
		odd.next=temp;
		return head;
	}
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static ListNode createList(int n) {
		ListNode dummy = new ListNode((int)1e8);
		ListNode prev=dummy;
		while(n-- >0) {
			prev.next=new ListNode(sc.nextInt());
			prev=prev.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode ll=createList(n);
		ListNode res=oddEven(ll);
		printList(res);
	}
}
