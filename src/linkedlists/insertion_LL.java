package linkedlists;
import java.util.*;

public class insertion_LL {
	public static class Node {
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
		Node(int data, Node next){
			this.data=data;
			this.next=next;
		}
	}
	
	public static Node insertFirst(Node head, int val) {
		Node newNode=new Node(val);
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	public static Node insertLast(Node head, int val) {
		if(head==null) return new Node(val);
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new Node(val);
		//temp.next.next=null;
		return head;
	}
	
	public static Node insertIdx(Node head, int idx,int ele) {
		if(head==null) {
			if(idx==1) return new Node(ele);
			else return null;
		}
		if(idx==1) {
			Node newNode = new Node(ele,head);
			head=newNode;
			return head;
		}
		Node temp=head;
		for(int i=2;i<idx;i++) {
			temp=temp.next;
		}
		Node temp2=new Node(ele);
		temp2.next=temp.next;
		temp.next=temp2;
		return head;
	}
	
	public static Node insertBeforeVal(Node head, int ele, int val) {
		if(head==null) return null;
		if(head.data==val) {
			return new Node(ele,head);
		}
		Node temp=head;
		while(temp.next!=null) {
			if(temp.next.data==val) {
				Node x=new Node(ele,temp.next);
				temp.next=x;
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {12,5,7,8};
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=mover.next;
		}
		Node res=insertFirst(head,6);
		//res=insertLast(head,13);
		//res=insertIdx(head,2,10);
		res=insertBeforeVal(head,11,13);
		while(res!=null) {
			System.out.print(res.data+"=>");
			res=res.next;
		}
		System.out.println("null");
	}

}
