package Lec_28;
import java.util.*;

public class balanced_brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='(' || ch=='{' || ch=='[') {
				st.push(ch);
			} else if (ch==')') {
				boolean val = handleClosing(st, '(');
				if(val==false) {
					System.out.println(val);
					return;
				}
			} else if(ch=='}') {
				boolean val = handleClosing(st, '{');
				if(val==false) {
					System.out.println(val);
					return;
				}
			} else if(ch==']') {
				boolean val = handleClosing(st, '[');
				if(val==false) {
					System.out.println(val);
					return;
				}
			}
		}
		if(st.size()==0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public static boolean handleClosing(Stack<Character> st, char ch) {
		if(st.size()==0 || st.peek()!=ch) {
			//System.out.println(false);
			return false;
		} else {
			st.pop();
			return true;
		}
	}
}
