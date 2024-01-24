package recursion;
import java.util.*;

public class palindrome_string {
	public static boolean isPalindrome(String str,int st, int end) {
		while(st<end) {
			if(str.charAt(st)==str.charAt(end)) {
				isPalindrome(str,st+1,end-1);
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println(isPalindrome(str,0,str.length()-1));
	}

}
