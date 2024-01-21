package linkedlists;
import java.util.*;

public class delete_middle_node_LL {
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
	
	public static ListNode deleteMid(ListNode head) {
		if(head==null||head.next==null) {
			return null;
		}
		ListNode temp=head;
		if(temp.next.next==null) {
			temp.next=null;
			return temp;
		}
		ListNode slow=head;
		ListNode fast=head;
		fast=fast.next.next;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=slow.next.next;
		return head;
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
		ListNode res=deleteMid(ll);
		printList(res);
	}

}
