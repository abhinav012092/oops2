package heap;
import java.util.*;
public class pq_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> PQ=new PriorityQueue<>(Collections.reverseOrder());
		PQ.add(69);
		PQ.add(31);
		PQ.add(54);
		PQ.add(17);
		PQ.add(26);
		PQ.add(25);
		PQ.add(38);
		System.out.println(PQ);
		//PQ.poll();
		while(!PQ.isEmpty()) {
			PQ.poll();
			System.out.println(PQ);
		}
		
	}
	
}
