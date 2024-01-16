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

public class intro_ll {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,5,8,7};
		Node y=new Node(arr[0]);
		Node x=y;
		System.out.println(x+"=>"+y);
	}

}
