package linkedlists;
import java.util.*;

import linkedlists.linkedlist_cycle.ListNode;

public class linkedlist_cycle_2 {
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
	
	public static ListNode cycleNode(ListNode head) {
		if(head==null||head.next==null) return null;
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			
			if(slow==fast) {
				break;
			}
		}
		if(slow!=fast) {
			return null;
		}
		slow=head;
		
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	public static ListNode takeInput() {
		int n=sc.nextInt();
		ListNode dummy=new ListNode(-1);
		ListNode prev=dummy;
		while(n-- >0) {
			prev.next=new ListNode(sc.nextInt());
			prev=prev.next;
		}
		int idx=sc.nextInt();
		if(idx>=0) {
			ListNode curr=dummy.next;
			while(idx-- >0) {
				curr=curr.next;
			}
			prev.next=curr;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=takeInput();
		ListNode ans=cycleNode(head);
		System.out.println(ans!=null?ans.val:-1);
	}

}
