package linkedlists;
import java.util.*;

import linkedlists.reverse_nodes_in_k_groups.ListNode;

public class Intersection_of_two_ll {
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
	
	public static ListNode startingNodeOfCycle(ListNode head) {
		if(head==null||head.next==null) {
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
			if(slow==fast) {
				break;
			}
		}
		if(slow!=fast) return null;
		slow=head;
		fast=fast;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	public static int length(ListNode head) {
		int len=0;
		if(head!=null) {
			len++;
			head=head.next;
		}
		return len;
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if((headA==null) || (headB==null)) {
			return null;
		}
		
		int lenA=length(headA);
		int lenB=length(headB);
		
		while(lenA > lenB) {
			lenA--;
			headA=headA.next;
		}
		
		while(lenB > lenA) {
			lenB--;
			headB = headB.next;
		}
		
		while(headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
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
		int m = sc.nextInt();
		ListNode l1 = createList(m);
		int n= sc.nextInt();
		ListNode l2 = createList(n);
		ListNode res=getIntersectionNode(l1,l2);
		printList(res);
	}

}
