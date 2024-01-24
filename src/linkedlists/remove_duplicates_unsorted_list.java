package linkedlists;
import java.util.*;
public class remove_duplicates_unsorted_list {
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
	public static ListNode removeDuplicatesUnsortedList(ListNode head) {
		HashSet<Integer> hs = new HashSet<>();
		ListNode current=head;
		ListNode prev=null;
		while(current!=null) {
			int curval=current.val;
			
			if(hs.contains(curval)) {
				prev.next=current.next;
			}else {
				hs.add(curval);
				prev=current;
			}
			current=current.next;
		}
		return head;
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
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode ll=createList(n);
		ListNode res=removeDuplicatesUnsortedList(ll);
		printList(res);
	}

}
