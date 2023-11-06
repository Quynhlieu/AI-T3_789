package lab5;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> froniter = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explore = new ArrayList<>();
		froniter.add(model.getInitialState());
		int count=0;
		while(!froniter.isEmpty()) {
			count++;
			Node current = froniter.poll();
			if(current.equals(model.getGoalState())) {
				System.out.println(count);
				return current;
			}else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if(!froniter.contains(child) && !explore.contains(child)) {
						froniter.add(child);
					}
				}
			}
//			System.out.println("Frontier");
//			for (Node node : froniter) {
//				System.out.print(node.print()+"; ");
//			}
//			System.out.println();
		}
		return null;
	}
}
