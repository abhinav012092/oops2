package linkedlists;
import java.util.*;

import linkedlists.linkedlist_cycle.ListNode;

public class add_two_numbers {
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
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null||l2==null) {
			return l1!=null?l1:l2;
		}
		
		ListNode c1=l1;
		ListNode c2=l2;
		
		ListNode head = new ListNode(-1);
		ListNode itr=head;
		
		int carry=0;
		while(c1!=null||c2!=null||carry!=0) {
			int sum=carry+(c1!=null?c1.val:0)+(c2!=null?c2.val:0);
			int ld=sum%10;
			carry=sum/10;
			
			itr.next=new ListNode(ld);
			itr=itr.next;
			
			if(c1!=null) {
				c1=c1.next;
			}
			if(c2!=null) {
				c2=c2.next;
			}
		}
		return head.next;
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
		int a = sc.nextInt();
		ListNode l1=createList(a);
		int b=sc.nextInt();
		ListNode l2=createList(b);
		ListNode res=addTwoNumbers(l1,l2);
		printList(res);
	}

}
