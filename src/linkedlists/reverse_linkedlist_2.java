package linkedlists;
import java.util.*;

import linkedlists.Intersection_of_two_ll.ListNode;

public class reverse_linkedlist_2 {
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
	
	public static ListNode getNodeAt(ListNode head, int idx) {
		ListNode temp=head;
		for(int i=1;i<idx;i++) {
			temp=temp.next;
		}
		return temp;
	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		while(left<right) {
			ListNode ll=getNodeAt(head,left);
			ListNode rr=getNodeAt(head,right);
			int temp=ll.val;
			ll.val=rr.val;
			rr.val=temp;
			left++;
			right--;
		}
		return head;
	}
	
	public static void printList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
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
		int n = sc.nextInt();
		ListNode l1=createList(n);
		int left=sc.nextInt();
		int right=sc.nextInt();
		ListNode res=reverseBetween(l1,left,right);
		printList(res);
	}

}
