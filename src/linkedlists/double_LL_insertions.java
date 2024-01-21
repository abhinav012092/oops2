package linkedlists;
import java.util.*;

public class double_LL_insertions {
	public static Scanner sc=new Scanner(System.in);
	public static class Node {
		int val=0;
		Node next=null;
		Node back=null;
		Node(int val){
			this.val=val;
			this.next=null;
			this.back=null;
		}
		Node(int val, Node next, Node back){
			this.val=val;
			this.next=next;
			this.back=back;
		}
	}
	public static Node addFirst(Node head, int val) {
		Node newHead=new Node(val,head,null);
		head.back=newHead;
		return newHead;
	}
	public static Node addBeforeTail(Node head, int val) {
		if(head.next==null) {
			Node newHead=new Node(val,head,null);
			head.back=newHead;
			return newHead;
		}
		Node tail=head;
		while(tail.next!=null) tail=tail.next;
		Node prev=tail.back;
		Node temp=new Node(val,tail,prev);
		prev.next=temp;
		tail.back=temp;
		return head;
	}
	public static Node insertBeforeK(Node head, int k,int val) {
		if(k==1) {
			Node newHead=new Node(val,head,null);
			head.back=newHead;
			return newHead;
		}
		Node temp=head;
		int cnt=0;
		while(temp!=null) {
			cnt++;
			if(cnt==k) break;
			temp=temp.next;
		}
		Node prev=temp.back;
		Node newNode=new Node(val,temp,prev);
		prev.next=newNode;
		temp.back=newNode;
		return head;
	}
	public static void insertBeforeNode(Node node, int val) {
		Node prev=node.back;
		Node newNode=new Node(val,node,prev);
		prev.next=newNode;
		node.back=newNode;
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
		//Node res=addFirst(dll,4);
		//res=addBeforeTail(dll,10);
		Node res=insertBeforeK(dll,4,100);
		insertBeforeNode(dll.next,7);
		printList(res);
	}

}
