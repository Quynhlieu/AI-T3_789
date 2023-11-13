package student;

public class SimulatedAnnealingSearch {
	public Node execute(Node initialState) {
		Node current = initialState;
		Node next = null;
		int T = 1000;
//		int count = 0;
		while(current.getH() != 0) {
//			count ++;
			if(T == 0) break;
			next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - current.getH();
			if(deltaE < 0) current = next;
			else {
				if(Math.exp(-deltaE/T) > Math.random())
					current = next;
			}
		}
//		System.out.println(count);
		return current;
	}
}
