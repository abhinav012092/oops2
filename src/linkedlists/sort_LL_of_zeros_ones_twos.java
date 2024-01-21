package linkedlists;
import java.util.*;

public class sort_LL_of_zeros_ones_twos {
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
	public static ListNode sortLL012(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode zeroHead=new ListNode(-1);
		ListNode oneHead=new ListNode(-1);
		ListNode twoHead=new ListNode(-1);
		
		ListNode zero=zeroHead,one=oneHead,two=twoHead,temp=head;
		while(temp!=null) {
			if(temp.val==0) {
				zero.next=temp;
				zero=temp;
			} else if(temp.val==1) {
				one.next=temp;
				one=temp;
			} else if(temp.val==2) {
				two.next=temp;
				two=temp;
			}
			temp=temp.next;
		}
		zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
		one.next=twoHead.next;
		two.next=null;
		return zeroHead.next;
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
		ListNode mover=dummy;
		while(n-- >0) {
			mover.next=new ListNode(sc.nextInt());
			mover=mover.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode ll=createList(n);
		ListNode res=sortLL012(ll);
		printList(res);
	}

}
