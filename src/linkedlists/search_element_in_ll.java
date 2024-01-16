package linkedlists;
import java.util.*;

class Node {
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

public class search_element_in_ll {
	public static int checkifPresent(Node head, int val) {
		Node temp=head;
		while(temp!=null) {
			if(temp.data==val) return 1;
			temp=temp.next;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=temp;
		}
		//head.next=new Node(arr[1]);
		//head.next.next=new Node(arr[2]);
		int val=1;
		//int res=checkifPresent(head,val);
		System.out.println(checkifPresent(head,val));
	}

}
