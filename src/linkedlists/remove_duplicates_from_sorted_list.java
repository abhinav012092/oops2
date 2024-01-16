package linkedlists;
import java.util.*;

import linkedlists.merge_two_sorted_ll.ListNode;

public class remove_duplicates_from_sorted_list {
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
	
	public static ListNode removeDuplicates(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode dummy = new ListNode((int)1e8);
		ListNode itr=dummy, curr=head;
		
		while(curr!=null) {
			while(curr!=null && itr.val==curr.val) {
				curr=curr.next;
			}
			itr.next=curr;
			itr=itr.next;
			
			if(curr!=null) {
				curr=curr.next;
			}
		}
		return dummy.next;
	}
	
	public static void printList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
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
		int m =sc.nextInt();
		ListNode l1=createList(m);
		ListNode res=removeDuplicates(l1);
		printList(res);
	}
}
