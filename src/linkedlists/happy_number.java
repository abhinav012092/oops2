package linkedlists;
import java.util.*;

public class happy_number {
	public static boolean isHappy(int n) {
		int slow=n;
		int fast=n;
		while(true) {
			slow=next(slow);
			fast=next(next(fast));
			if(slow==1||fast==1) {
				return true;
			}
			if(slow==fast) {
				return false;
			}
		}
	}
	
	public static int next(int num) {
		int ans=0;
		while(num>0) {
			int digit=num%10;
			num/=10;
			ans+=(digit*digit);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(isHappy(n));
	}

}
