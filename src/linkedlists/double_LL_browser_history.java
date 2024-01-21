package linkedlists;
import java.util.*;

public class double_LL_browser_history {
	public static Scanner sc=new Scanner(System.in);
	public static class Node {
		String data;
		Node next;
		Node back;
		Node(){
			this.data="";
			this.next=null;
			this.back=null;
		}
		Node(String x){
			this.data=x;
			this.next=next;
			this.back=back;
		}
		Node(String x, Node next, Node back){
			this.data=x;
			this.next=next;
			this.back=back;
		}
	}
	public static Node currentPage;
	public double_LL_browser_history(String homepage) {
		currentPage = new Node(homepage);
	}
	public static void visit(String url) {
		Node newNode=new Node(url);
		currentPage.next=newNode;
		newNode.back=currentPage;
		currentPage=newNode;
	}
	public static String back(int steps) {
		while(steps>0) {
			if(currentPage.back!=null) {
				currentPage=currentPage.back;
			} else {
				break;
			}
			steps--;
		}
		return currentPage.data;
	}
	public static String forward(int steps) {
		while(steps>0) {
			if(currentPage.next!=null) {
				currentPage=currentPage.next;
			}else {
				break;
			}
			steps--;
		}
		return currentPage.data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double_LL_browser_history obj = new double_LL_browser_history("takeuforward.org");
		obj.visit("www.google.com");
		String two=obj.back(2);
		String three=obj.forward(3);
	}

}
