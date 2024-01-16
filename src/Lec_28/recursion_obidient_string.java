package Lec_28;
import java.util.*;

public class recursion_obidient_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (recurse(str, 0))
            System.out.println("true");
        else
            System.out.println("false");
	}
	
	public static boolean recurse(String str, int i) {
		if(i>=str.length()) {
			return true;
		}
		if(str.charAt(i)!='a' && str.charAt(i)!='b') {
			return false;
		}
		if(str.charAt(i)=='b') {
			if((i<str.length()-1)&&str.charAt(i+1)=='b')
				return recurse(str, i+2);
			else
				return false;
		}
		return recurse(str, i+1);
	}

}
