package linkedlists;
import java.util.*;

public class k_reverse_ll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void kReverse(int k) {
		LinkedList prev = null;
		while(this.size>0) {
			LinkedList curr = new LinkedList();
			if(this.size>0) {
				for(int i=0;i<k;i++) {
					int val = this.getFirst();
					this.removeFirst();
					curr.addFirst(val);
				}
			} else {
				int os = this.size();
				for(int i=0;i<os;i++) {
					int val=this.getFirst();
					this.removeFirst();
					curr.addLast(val);
				}
			}
			if(prev==null) {
				prev=curr;
			}else {
				prev.tail.next=curr.head;
				prev.tail=curr.tail;
				prev.size += curr.size;
			}
		}
		this.head=prev.head;
		this.tail=prev.tail;
		this.size=prev.size;
	}
	
	public void Rev() {
		Node curr=head;
		Node prev=null;
		while(curr!=null) {
			System.out.println(curr.data+" - "+prev);
			prev=curr;
			curr=curr.next;
		}
	}
	
	public Node Rev2(Node nn) {
		if(nn.next==null) {
			head=nn;
			return nn;
		}
		Node Tail = Rev2(nn.next);
		Tail.next=nn;
		nn.next=null;
		return nn;
	}
	
	private Node revk(Node nn, int k) {
		if(nn==null) {
			return null;
		}
		Node temp = nn;
		for(int i=0;i<k;i++) {
			if(temp==null) {
				return nn;
			}
			temp=temp.next;
		}
		Node head = revk(temp);
		
		Node curr=nn;
		Node prev=null;
		for(int i=0;i<k;i++) {
			Node after=curr.next;
			System.out.println(curr.data);
			curr.next=prev;
			prev=curr;
			curr=after;
		}
		nn.next=head;
		return prev;
	}
	
	public void revk_iter(int k) {
		Node nhead=null;
		Node ntail=null;
		Stack<Node> S = new Stack<>();
		Node curr = head;
		while(curr!=null) {
			Node after = curr.next;
			S.add(curr);
			if(S.size()==k) {
				while(!S.isEmpty()) {
					Node nn = S.pop();
					if(nhead==null) {
						nhead=nn;
						ntail=nn;
						ntail.next=null;
					} else {
						ntail.next=nn;
						ntail=nn;
						ntail.next=null;
					}
				}
			}
			curr=after;
		}
		head=nhead;
	}
	
	public void Mid() {
		Node slow = head;
		Node fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println(slow.data);
	}
	
	public boolean hasCycle() {
		Node slow = head;
		Node fast = head;
		while(fast.next!=null && fast!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		if(slow==fast) {
			return false;
		} else {
			return true;
		}
	}
}
