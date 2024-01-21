package linkedlists;
import java.util.*;

import linkedlists.linkedlist_cycle.ListNode;

public class length_of_loop_ll {
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
	
	public static int lengthCycle(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		if(slow!=fast) return 0;
		fast=fast.next;
		int cnt=1;
		while(slow!=fast) {
			cnt++;
			fast=fast.next;
		}
		return cnt;
	}
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
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
		createCycle(ll,sc.nextInt());
		System.out.println(lengthCycle(ll));
	}

}
