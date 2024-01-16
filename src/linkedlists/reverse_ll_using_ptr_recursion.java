package linkedlists;
import java.util.*;

import linkedlists.display_reverse_ll_using_recursion.ListNode;

public class reverse_ll_using_ptr_recursion {
	public static Scanner sc = new Scanner(System.in);
	
	public static class ListNode {
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
	
	public static ListNode reversePR(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode newHead=reversePR(head.next);
		
		ListNode front=head.next;
		front.next=head;
		head.next=null;
		return newHead;
	}
	
	public static ListNode createList(int n) {
		ListNode dummy = new ListNode(-1);
		ListNode prev=dummy;
		while(n-- >0) {
			prev.next=new ListNode(sc.nextInt());
			prev=prev.next;
		}
		return dummy.next;
	}
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		ListNode ll=createList(n);
		ListNode res=reversePR(ll);
		printList(res);
	}

}
