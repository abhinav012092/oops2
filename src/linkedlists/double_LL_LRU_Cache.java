package linkedlists;
import java.util.*;
public class double_LL_LRU_Cache {
	
	public static class Node {
		int key,val;
		Node next,prev;
	}
	HashMap<Integer,Node> cache;
 	Node head,tail;
 	int cap;
	public void addNode(Node node) {
		Node nbr=head.next;
		node.next=nbr;
		nbr.prev=node;
		node.prev=head;
		head.next=node;
	}
	public void removeNode(Node node) {
		Node last=node.prev;
		Node front=node.next;
		last.next=front;
		front.prev=last;
		node.next=node.prev=null;
	}
	public void moveToFirst(Node node) {
		removeNode(node);
		addNode(node);
	}
	public double_LL_LRU_Cache(int capacity) {
		cache=new HashMap<>();
		cap=capacity;
		head=new Node();
		tail=new Node();
		
		head.next=tail;
		tail.prev=head;
	}
	public int get(int key) {
		Node node=cache.get(key);
		if(node==null) {
			return -1;
		}else {
			int v1=node.val;
			moveToFirst(node);
			return v1;
		}
	}
	public void put(int key, int val) {
		Node node=cache.get(key);
		if(node==null) {
			Node newNode=new Node();
			newNode.key=key;
			newNode.val=val;
			
			if(cache.size()==cap) {
				Node LRU_Node=tail.prev;
				cache.remove(LRU_Node.key);
				removeNode(LRU_Node);
			}
		}else {
			node.val=val;
			moveToFirst(node);
		}
	}
}
