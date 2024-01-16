package linkedlists;
import java.util.*;

import linkedlists.remove_Nth_node_from_end_of_list.ListNode;

public class rotate_list {
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
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode tail=head;
		ListNode temp=head;
		int length=1;
		while(tail.next!=null) {
			length++;
			tail=tail.next;
		}
		k=k%length;
		if(k==0) {
			return head;
		}
		tail.next=head;
		int cnt=1;
		while(cnt<length-k) {
			temp=temp.next;
			cnt++;
		}
		head=temp.next;
		temp.next=null;
		return head;
	}
	
	public static void printList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
	}
	
	public static ListNode createList(int m) {
		ListNode dummy=new ListNode(-1);
		ListNode prev=dummy;
		while(m-- >0) {
			prev.next=new ListNode(sc.nextInt());
			prev=prev.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = sc.nextInt();
		ListNode l1 = createList(m);
		int k=sc.nextInt();
		ListNode res=rotateRight(l1,k);
		printList(res);
	}

}
