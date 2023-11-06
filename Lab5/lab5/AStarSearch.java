package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> explore = new ArrayList<>();
		int count = 0;
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			count++;
			Node current = frontier.poll();
			if (current.equals(model.getGoalState())) {
				System.out.println(count);
				return current;
			}else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					int newPath = current.getG() + 1;
					if (!frontier.contains(child) && !explore.contains(child)) {
						child.setG(newPath);
						frontier.add(child);
					} else if (frontier.contains(child) && child.getG() > newPath) {
						frontier.remove(child);
						child.setG(newPath);
						frontier.add(child);
					}
				}
			}
		}

		return null;
	}

}
