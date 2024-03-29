package Lec_28;
import java.util.*;

public class Queue_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> Q = new LinkedList<>();
		Q.add(10);
		Q.add(20);
		Q.add(30);
		Q.add(40);
		System.out.println(Q);
		Rev(Q);
		System.out.println(Q);
		int[] arr = {-20,10,-5,4,6,-9,-80,60,50};
		firstNegWinK(arr,3);
	}
	
	public static void Rev(Queue<Integer> Q) {
		Stack<Integer> S = new Stack<>();
		while(!Q.isEmpty()) {
			S.add(Q.poll());
		}
		while(!S.isEmpty()) {
			Q.add(S.pop());
		}
	}
	
	public static void firstNegWinK(int[] arr, int k) {
		Queue<Integer> Q = new LinkedList<>();
		for(int i=0;i<k;i++) {
			if(arr[i]<0) {
				Q.add(i);
			}
		}
		for(int s=1;s<=arr.length-k;s++) {
			if(!Q.isEmpty() && Q.peek()==s-1) {
				Q.poll();
			}
			int e = s+k-1;
			if(arr[e]<0) {
				Q.add(e);
			}
			if(!Q.isEmpty()) {
				System.out.println(arr[Q.peek()]);
			} else {
				System.out.println("not possible");
			}
		}
	}
}
