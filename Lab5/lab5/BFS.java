package lab5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		Queue<Node> frontier = new LinkedList<>();
		List<Node> explore = new ArrayList<>();
		int count = 0;
		
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			count++;
			Node current = frontier.poll();
			if(current.equals(model.getGoalState())) {
				System.out.println(count);
				return current;
			}
			else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if(!frontier.contains(child) && !explore.contains(child)) {
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

}
