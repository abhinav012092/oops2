package stacks;
import java.util.*;

public class stock_span {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int[] span = solve(arr);
		System.out.println(Arrays.toString(span));
	}
	
	public static int[] solve(int[] arr) {
		int[] span = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		span[0]=1;
		for(int i=0;i<arr.length;i++) {
			while(st.size()>0 && arr[i]>arr[st.peek()]) {
				st.pop();
			}
			if(st.size()==0) {
				span[i]=i+1;
			} else {
				span[i]=i-st.peek();
			}
			st.push(i);
		}
		return span;
	}

}
