package linkedlists;
import java.util.*;

import linkedlists.intersection_of_two_ll_2.ListNode;

public class linkedlist_cycle {
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
	public static boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) return false;
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		return false;
	}
	
	public static void createCycle(ListNode head, int pos) {
		ListNode ptr=head;
		ListNode temp=head;
		int cnt=0;
		while(temp.next!=null) {
			if(cnt!=pos) {
				++cnt;
				ptr=ptr.next;
			}
			temp=temp.next;
		}
		temp.next=ptr;
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
		//createCycle(ll,2);
		System.out.println(hasCycle(ll));
	}

}
