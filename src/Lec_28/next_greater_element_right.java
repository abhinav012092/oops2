package Lec_28;
import java.util.*;

public class next_greater_element_right {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int[] ans = nextgr8(arr);
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] nextgr8(int[] arr) {
		int[]nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr[arr.length-1]);
		nge[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--) {
			//1pop 2ans 3push 
			while(st.size()>0 && arr[i]>st.peek()) {
				st.pop();
			}
			if(st.size()==0) {
				nge[i]=-1;
			} else {
				nge[i]=st.peek();
			}
			st.push(arr[i]);
		}
		return nge;
	}

}
