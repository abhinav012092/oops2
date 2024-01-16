package linkedlists;
import java.util.*;

import linkedlists.remove_duplicates_from_sorted_list.ListNode;

public class remove_duplicates_from_sorted_list_II {
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
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode dummy=new ListNode((int)1e8);
		ListNode itr=dummy;
		itr.next=head;//potential unique element
		ListNode curr=head.next;
		
		while(curr!=null) {
			boolean flag=false;
			while(curr!=null && itr.next.val==curr.val) {
				curr=curr.next;
				flag=true;
			}
			if(flag) {
				itr.next=curr;
			} else {
				itr=itr.next;
			}
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
		ListNode res=deleteDuplicates(l1);
		printList(res);
	}
}
