package linkedlists;
import java.util.*;

public class delete_ll {
	
	public static class Node {
		int data;
		Node next;
		
		Node(int data1, Node next1){
			this.data=data1;
			this.next=next1;
		}
		Node(int data1){
			this.data=data1;
		}
	}
	
	public static Node deleteHead(Node head) {
		if(head==null) return null;
		head=head.next;
		return head;
	}
	
	public static Node deleteTail(Node head) {
		if(head==null||head.next==null) return null;
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		return head;
	}
	
	public static Node deletek(Node head, int k) {
		if(head==null) return null;
		if(k==1) {
			head=head.next;
			return head;
		}
		int cnt=0;
		Node temp=head;
		Node prev=null;
		while(temp!=null) {
			cnt++;
			if(cnt==k) {
				prev.next=prev.next.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}
	
	public static Node deleteEle(Node head, int ele) {
		if(head==null) return null;
		if(head.data==ele) {
			head=head.next;
			return head;
		}
		Node temp=head;
		Node prev=null;
		while(temp!=null) {
			if(temp.data==ele) {
				prev.next=prev.next.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {12,8,5,4,7,6};
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=mover.next;
		}
		//Node res=deletek(head,3);
		//res=deleteTail(head);
		Node res=deleteHead(head);
		while(res!=null) {
			System.out.print(res.data+"=>");
			res=res.next;
		}
		System.out.println("null");
	}
}
