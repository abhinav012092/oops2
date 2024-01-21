package linkedlists;
import java.util.*;

public class max_consecutive_1s {
	public static Scanner sc=new Scanner(System.in);
	public static class ListNode {
		int val=0;
		ListNode next=null;
		ListNode(int val){
			this.val=val;
			this.next=null;
		}
		ListNode(int val, ListNode next){
			this.val=val;
			this.next=next;
		}
	}
	public static int maxConsecutive1s(ListNode head) {
		ListNode temp=head;
		int cnt=0,maxCnt=0;
		while(temp!=null) {
			if(temp.val==1) {
				cnt++;
				maxCnt=Math.max(cnt, maxCnt);
			} else if(temp.val==0) {
				cnt=0;
			}
			temp=temp.next;
		}
		return maxCnt;
	}
	public static ListNode createList(int n) {
		ListNode dummy=new ListNode((int)1e8);
		ListNode mover=dummy;
		while(n-- >0) {
			mover.next=new ListNode(sc.nextInt());
			mover=mover.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		ListNode ll=createList(n);
		System.out.println(maxConsecutive1s(ll));
	}

}
