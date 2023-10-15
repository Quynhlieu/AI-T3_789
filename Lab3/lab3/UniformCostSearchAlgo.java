package lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {
	class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			double num = o1.getPathCost() - o2.getPathCost();
			if (num == 0) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
			return (int) num * 10;
		}

	}

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> froniter = new PriorityQueue<Node>(new NodeComparator());
		froniter.add(root);
		List<Node> explored = new ArrayList<>();
		while (!froniter.isEmpty()) {
			Node current = froniter.poll();
			if (current.getLabel().equals(goal))
				return current;
			else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if (!froniter.contains(end) && !explored.contains(end)) {
						end.setParent(current);
						end.setPathCost(newPathCost);
						froniter.add(end);
					} else if (end.getPathCost() > newPathCost && froniter.contains(end)) {
						froniter.remove(end);
						end.setParent(current);
						end.setPathCost(newPathCost);
						froniter.add(end);
					}
				}
			}
		}
		return null;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		PriorityQueue<Node> froniter = new PriorityQueue<Node>(new NodeComparator());
		froniter.add(root);
		List<Node> explored = new ArrayList<>();
		while (!froniter.isEmpty()) {
			Node current = froniter.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				current.setParent(null);
				current.setPathCost(0);
				froniter.clear();
				explored.clear();
			}

			if (current.getLabel().equals(goal) && started == true)
				return current;
			else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if (!froniter.contains(end) && !explored.contains(end)) {
						end.setParent(current);
						end.setPathCost(newPathCost);
						froniter.add(end);
					} else if (end.getPathCost() > newPathCost && froniter.contains(end)) {
						end.setParent(current);
						end.setPathCost(newPathCost);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
