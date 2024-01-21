package linkedlists;
import java.util.*;

public class sort_LL {
	public static Scanner sc=new Scanner(System.in);
	
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode(int val){
			this.val=val;
			this.next=null;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	
	public static ListNode findMid(ListNode head) {
		ListNode slow=head;
		ListNode fast=head.next;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode((int)1e8);
		ListNode temp=dummy;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				temp.next=l1;
				temp=temp.next;
				l1=l1.next;
			} else {
				temp.next=l2;
				temp=temp.next;
				l2=l2.next;
			}
		}
		if(l1!=null) {
			temp.next=l1;
		}else {
			temp.next=l2;
		}
		return dummy.next;
	}
	public static ListNode sortList(ListNode head) {
		if(head==null||head.next==null) return head;
		
		ListNode middle=findMid(head);
		ListNode right=middle.next;
		middle.next=null;
		ListNode left=head;
		
		left=sortList(left);
		right=sortList(right);
		return mergeTwoLists(left,right);
	}
	
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	
	public static ListNode createList(int n) {
		ListNode dummy=new ListNode(-1);
		ListNode temp=dummy;
		while(n-- >0) {
			temp.next=new ListNode(sc.nextInt());
			temp=temp.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode ll=createList(n);
		ListNode res=sortList(ll);
		printList(res);
	}

}
