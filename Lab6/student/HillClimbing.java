package student;

import java.util.PriorityQueue;

public class HillClimbing {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;
	
	public Node execute(Node initialState) {
		Node current = initialState;
		Node neighbour = null;
		stepClimbed = 0;
		while (true) {
			neighbour = current.getBestNode();
			if (neighbour.getH() < current.getH()) {
				stepClimbed++;
				stepClimbedAfterRandomRestart++;
				current = neighbour;
			} else {
				return current;
			}
		}
	}
	

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		
		Node current = execute(initialState);
		while (current.getH() != 0) {
			current.generateBoard();
			current = execute(current);
			randomRestarts++;
		}

		return current;
	}
	public Node selectNextRandomCandidate() {
		
		return null;
	}
}
