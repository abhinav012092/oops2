package linkedlists;
import java.util.*;

import linkedlists.Intersection_of_two_ll.ListNode;

public class intersection_of_two_ll_2 {
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
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1=length(headA);
		int len2=length(headB);
		
		ListNode bigone=(len1>len2?headA:headB);
		ListNode smallone=(len1<len2?headA:headB);
		int diff=Math.max(len1, len2)-Math.min(len1, len2);
		
		while(diff>0) {
			bigone=bigone.next;
			diff--;
		}
		
		while(bigone!=smallone) {
			bigone=bigone.next;
			smallone=smallone.next;
		}
		return bigone;
	}
	
	public static int length(ListNode head) {
		if(head==null) {
			return 0;
		}
		int len=0;
		ListNode curr=head;
		while(curr!=null) {
			len++;
			curr=curr.next;
		}
		return len;
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
		int a = sc.nextInt();
		ListNode l1 = createList(a);
		int b=sc.nextInt();
		ListNode l2=createList(b);
		ListNode res=getIntersectionNode(l1,l2);
		printList(res);
		
	}

}
