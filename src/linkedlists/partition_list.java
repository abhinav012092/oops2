/*
Given the head of a linked list and a value x, partition it such that all nodes 
less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions
 */
package linkedlists;
import java.util.*;

import linkedlists.add_two_numbers.ListNode;

public class partition_list {
	public static Scanner sc = new Scanner(System.in);
	
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode(){};
		ListNode(int val){
			this.val=val;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	
	public static ListNode partition(ListNode head, int x) {
		ListNode small=new ListNode();
		ListNode big=new ListNode();
		
		ListNode smallHead=small;
		ListNode bigHead=big;
		while(head!=null) {
			if(head.val<x) {
				smallHead.next=head;
				smallHead=smallHead.next;
			}else {
				bigHead.next=head;
				bigHead=bigHead.next;
			}
			head=head.next;
		}
		bigHead.next=null;
		smallHead.next=big.next;
		return small.next;
	}
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
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
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode l1=createList(n);
		int x=sc.nextInt();
		ListNode res=partition(l1,x);
		printList(res);
	}

}
