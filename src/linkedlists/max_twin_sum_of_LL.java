package linkedlists;
import java.util.*;

public class max_twin_sum_of_LL {
	public static Scanner sc=new Scanner(System.in);
	
	public static class ListNode{
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
	public static ListNode midNode(ListNode head) {
		ListNode slow=head;
		ListNode fast=head.next;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static ListNode reverse(ListNode head) {
		ListNode prev=null;
		ListNode curr=head;
		while(curr!=null) {
			ListNode front=curr.next;
			curr.next=prev;
			prev=curr;
			curr=front;
		}
		return prev;
	}
	public static int pairSum(ListNode head) {
		ListNode mid=midNode(head);
		ListNode nHead=mid.next;
		mid.next=null;
		nHead=reverse(nHead);
		
		ListNode t1=head;
		ListNode t2=nHead;
		int sum=0;
		while(t2!=null) {
			sum=Math.max(t1.val+t2.val, sum);
			t1=t1.next;
			t2=t2.next;
		}
		return sum;
	}
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	public static ListNode createList(int n) {
		ListNode dummy=new ListNode((int)1e8);
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
		System.out.println(pairSum(ll));
	}

}
