package linkedlists;

import java.util.Scanner;

import linkedlists.middle_of_the_ll.ListNode;

public class palindrome_ll {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val){
			this.val=val;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode pre=null;
		ListNode curr=head;
		while(curr!=null) {
			ListNode frw=curr.next;
			curr.next=pre;
			pre=curr;
			curr=frw;
		}
		return pre;
	}
	
	public static boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) {
			return true;
		}
		ListNode mid=middleNode(head);
		ListNode nhead=mid.next;
		mid.next=null;
		nhead=reverse(nhead);
		
		ListNode c1=head;
		ListNode c2=nhead;
		
		boolean flag=true;
		while(c2!=null) {
			if(c1.val!=c2.val) {
				flag=false;
				break;
			}
			c1=c1.next;
			c2=c2.next;
		}
		nhead=reverse(nhead);
		mid.next=nhead;
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ListNode dummy = new ListNode(-1);
		ListNode prev=dummy;
		ListNode m = prev;
		while(n-- >0) {
			prev.next=new ListNode(sc.nextInt());
			prev=prev.next;
		}
		/*ListNode rev=reverse(m);
		while(rev.next!=null) {
			System.out.print(rev.val+" ");
			rev=rev.next;
		}*/
		
		System.out.println(isPalindrome(m.next));
	}

}
