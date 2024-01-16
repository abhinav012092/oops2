package linkedlists;
import java.util.*;

import linkedlists.partition_list.ListNode;

public class display_reverse_ll_using_recursion {
	public static Scanner sc = new Scanner(System.in);
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(){};
		ListNode(int val){
			this.val=val;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	
	public static void display_reverse_rec(ListNode head) {
		if(head==null) return;
		display_reverse_rec(head.next);
		System.out.print(head.val+" ");
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		ListNode l1=createList(n);
		display_reverse_rec(l1);
		//printList(res);
	}

}
