package linkedlists;
import java.util.*;

public class copy_list_with_random_ptr {
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode random=null;
		ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode copyRandomList(ListNode head) {
		HashMap<ListNode,ListNode> map= new HashMap<>();
		ListNode curr=head;
		
		ListNode nHead = new ListNode(-1);
		ListNode prev=nHead;
		
		while(curr!=null) {
			ListNode node=new ListNode(curr.val);
			prev.next=node;
			
			map.put(curr, node);
			
			prev=prev.next;
			curr=curr.next;
		}
		nHead=nHead.next;
		ListNode c1=head;
		ListNode c2=nHead;
		while(c1!=null) {
			if(c1.random!=null) {
				c2.random=map.get(c1.random);
			} else {
				c2.random=null;
			}
			c1=c1.next;
			c2=c2.next;
		}
		return nHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ListNode[] arr = new ListNode[n];
		ListNode prev=null;
		for(int i=0;i<n;i++) {
			arr[i]= new ListNode(0);
			if(prev!=null) {
				prev.next=arr[i];
			}
			prev=arr[i];
		}
		for(int i=0;i<n;i++) {
			int val=sc.nextInt();
			int idx=sc.nextInt();
			arr[i].val=val;
		}
	}

}
