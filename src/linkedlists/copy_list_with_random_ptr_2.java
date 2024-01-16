package linkedlists;
import java.util.*;

import linkedlists.copy_list_with_random_ptr.ListNode;

public class copy_list_with_random_ptr_2 {
	
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode random=null;
		ListNode(int val){
			this.val=val;
		}
	}
	
	public static void copyOriginalNodes(ListNode head) {
		ListNode curr=head;
		while(curr!=null) {
			ListNode newNode=new ListNode(curr.val);
			newNode.next=curr.next;
			curr.next=newNode;
			curr=newNode.next;//curr=curr.next.next;
		}
	}
	
	public static void assignRandomPtr(ListNode head) {
		ListNode curr=head;
		while(curr!=null) {
			if(curr.random==null) {
				curr.next.random=null;
			} else {
				curr.next.random=curr.random.next;
			}
			curr=curr.next.next;
		}
	}
	
	public static ListNode newListCreator(ListNode head) {
		ListNode curr=head;
		ListNode dummyHead=new ListNode(-1);
		ListNode mover=dummyHead;
		
		while(curr!=null) {
			mover.next=curr.next;
			mover=mover.next;
			curr=curr.next.next;
		}
		return dummyHead.next;
	}
	public static ListNode copyRandomList(ListNode head) {
		copyOriginalNodes(head);
		assignRandomPtr(head);
		return newListCreator(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
