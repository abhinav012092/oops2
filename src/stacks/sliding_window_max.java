package stacks;
import java.util.*;

public class sliding_window_max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int win_size = sc.nextInt();
		int[] swm =new int[n-win_size]; 
		swm = solve(arr, win_size);
		System.out.println(Arrays.toString(swm));
	}
	public static int[] solve(int[] arr, int win_size) {
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr.length-1);
		nge[arr.length-1]=arr.length;
		
		for(int i=arr.length-2;i>=0;i--) {
			while(st.size()>0 && arr[i]>=arr[st.peek()]) {
				st.pop();
			}
			if(st.size()==0) {
				nge[i]=arr.length;
			} else {
				nge[i]=st.peek();
			}
			st.push(i);
		}
		int[] ans = new int[arr.length-win_size];
		int j=0;
		for(int i=0;i<arr.length-win_size;i++) {
			if(j<i) {
				j=i;
			}
			while(nge[j]<i+win_size) {
				j=nge[j];
			}
			ans[i]=arr[j];
		}
		return ans;
	}
}
