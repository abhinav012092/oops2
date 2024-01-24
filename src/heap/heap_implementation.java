package heap;
import java.util.*;

public class heap_implementation {
	ArrayList<Integer> AL;
	public heap_implementation() {
		AL=new ArrayList<>();
	}
	public int size() {
		return AL.size();
	}
	public int peek() {
		return AL.get(0);
	}
	public void add(int ele) {
		AL.add(ele);
		upheapify(AL.size()-1);
	}
	private void upheapify(int ch) {
		int p=(ch-1)/2;
		if(AL.get(p)>AL.get(ch)) {
			swap(ch,p);
			upheapify(p);
		}
	}
	private void swap(int a, int b) {
		int temp=AL.get(a);
		AL.set(a, b);
		AL.set(b, temp);
	}
	public int poll() {
		int ans=AL.get(0);
		AL.set(0, AL.get(AL.size()-1));
		AL.remove(AL.size()-1);
		downheapify(0);
		return ans;
	}
	private void downheapify(int p) {
		int L=2*p+1;
		int R=2*p+2;
		int min_idx=p;
		if(L<AL.size() && AL.get(L)<AL.get(min_idx)) {
			min_idx=L;
		}
		if(R<AL.size() && AL.get(R)<AL.get(min_idx)) {
			min_idx=R;
		}
		if(p!=min_idx) {
			swap(p,min_idx);
			downheapify(min_idx);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
