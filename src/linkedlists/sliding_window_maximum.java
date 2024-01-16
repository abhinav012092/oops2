package linkedlists;
import java.util.*;

public class sliding_window_maximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		LinkedList<Integer> ll = new LinkedList<>();
		int[] res=new int[nums.length-k+1];
		int j=0;
		for(int i=0;i<k;i++) {
			while(!ll.isEmpty() && nums[ll.getLast()]<nums[i]) {
				ll.removeLast();
			}
			ll.addLast(i);
		}
		res[j++]=nums[ll.getFirst()];
		
		for(int i=k;i<nums.length;i++) {
			while(!ll.isEmpty() && ll.getFirst()<=i-k) {
				ll.removeFirst();
			}
			while(!ll.isEmpty() && nums[ll.getLast()]<nums[i]) {
				ll.removeLast();
			}
			ll.addLast(i);
			res[j++]=nums[ll.getFirst()];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		int[] res=new int[arr.length-k+1];
		res=maxSlidingWindow(arr,k);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

}
