package Lec_28;
import java.util.*;

public class happy_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isHappy(n));
	}
	public static boolean isHappy(int n) {
		int slow=n;
		int fast=n;
		while(true) {
			slow=next(slow);
			fast=next(next(slow));
		}
	}
}
