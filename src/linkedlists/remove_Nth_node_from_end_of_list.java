package linkedlists;
import java.util.*;

public class remove_Nth_node_from_end_of_list {
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
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null||head.next==null) {
			return null;
		}
		ListNode c1=head;
		ListNode c2=head;
		
		while(n-- >0) {
			c2=c2.next;
		}
		
		if(c2==null) {
			return head.next;
		}
		
		while(c2.next!=null) {
			c1=c1.next;
			c2=c2.next;
		}
		
		c1.next=c1.next.next;
		return head;
	}
	
	public static void printList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
	}
	
	public static ListNode createList(int m) {
		ListNode dummy=new ListNode((int)1e8);
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
		int n=sc.nextInt();
		ListNode res=removeNthFromEnd(l1,n);
		printList(res);
	}

}
