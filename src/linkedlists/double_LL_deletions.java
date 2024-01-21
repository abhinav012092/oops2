package linkedlists;
import java.util.*;

public class double_LL_deletions {
	public static Scanner sc = new Scanner(System.in);
	
	public static class Node {
		int val=0;
		Node next=null;
		Node back=null;
		Node(int val){
			this.val=val;
			this.next=null;
			this.back=null;
		}
		Node(int val, Node next,Node back){
			this.val=val;
			this.next=next;
			this.back=back;
		}
	}
	public static Node deleteHead(Node head) {
		if(head==null||head.next==null) return null;
		Node prev=head;
		head=head.next;
		head.back=null;
		prev.next=null;
		return head;
	}
	public static Node deleteTail(Node head) {
		if(head==null||head.next==null) return null;
		Node tail=head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		Node prev=tail.back;
		prev.next=null;
		tail.back=null;
		return head;
	}
	public static Node deleteKthele(Node head, int k) {
		if(head==null||head.next==null) return null;
		Node temp=head;
		int cnt=0;
		while(temp!=null) {
			cnt++;
			if(cnt==k) break;
			temp=temp.next;
		}
		Node prev=temp.back;
		Node front=temp.next;
		if(prev==null) {
			head=head.next;
			head.back=null;
			return head;
		}else if(front==null) {
			Node tail=head;
			while(tail.next!=null) {
				tail=tail.next;
			}
			Node prev2=tail.back;
			tail.back=null;
			prev2.next=null;
			return head;
		}
		prev.next=front;
		front.back=prev;
		temp.next=temp.back=null;
		return head;
	}
	public static void deleteNode(Node temp) {
		Node prev=temp.back;
		Node front=temp.next;
		if(front==null) {
			prev.next=null;
			temp.back=null;
		}
		prev.next=front;
		front.back=prev;
		temp.back=temp.next=null;
	}
	public static Node convertArrtoDLL(int[] arr) {
		Node head=new Node(arr[0]);
		Node prev=head;
		for(int i=1;i<arr.length;i++) {
			Node temp=new Node(arr[i],null,prev);
			prev.next=temp;
			prev=prev.next;
		}
		return head;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.val+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Node dll=convertArrtoDLL(arr);
		//Node res=deleteKthele(dll,sc.nextInt());
		deleteNode(dll.next);
		printList(dll);
	}
}
