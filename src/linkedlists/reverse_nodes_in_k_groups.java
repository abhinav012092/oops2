package linkedlists;
import java.util.*;

import linkedlists.rotate_list.ListNode;

public class reverse_nodes_in_k_groups {
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
	
	static ListNode th;
	static ListNode tt;
	public static void addFirstNode(ListNode node) {
		if(th==null) {
			th=node;
			tt=node;
		}else {
			node.next=th;
			th=node;
		}
	}
	
	public static int length(ListNode head) {
		ListNode curr = head;
		int len=0;
		while(curr!=null) {
			len++;
			curr=curr.next;
		}
		return len;
	}
	
	public static ListNode reverseInKGroup(ListNode head, int k) {
		if(head==null||head.next==null||k<=1) {
			return head;
		}
		ListNode ot=null;
		ListNode oh=null;
		
		ListNode curr=head;
		int length=length(head);
		
		while(length>=k) {
			for(int i=0;i<k;i++) {
				ListNode save=curr.next;
				curr.next=null;
				addFirstNode(curr);
				curr=save;
			}
			if(oh==null) {
				oh=th;
				ot=tt;
			}else {
				ot.next=th;
				ot=tt;
			}
			length-=k;
			th=tt=null;
		}
		if(curr!=null) {
			ot.next=curr;
		}
		return oh;
	}
	
	public static ListNode reversell(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode prev=null;
		ListNode curr=head;
		while(curr!=null) {
			ListNode frw=curr.next;
			curr.next=prev;
			prev=curr;
			curr=frw;
		}
		return prev;
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
		ListNode l1 = createList(n);
		int k=sc.nextInt();
		ListNode res=reverseInKGroup(l1,k);
		printList(res);
	}

}
