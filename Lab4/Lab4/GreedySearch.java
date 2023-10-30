package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedySearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> froniter = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> explore = new ArrayList<>();
		froniter.add(root);
		while (!froniter.isEmpty()) {
			Node current = froniter.poll();
			if (current.getLabel().equals(goal))
				return current;
			else {
				explore.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					if (!froniter.contains(child) && !explore.contains(child)) {
						child.setParent(current);
						froniter.add(child);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> froniter = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> explore = new ArrayList<>();
		boolean started = false;
		froniter.add(root);
		while (!froniter.isEmpty()) {
			Node current = froniter.poll();
			if(current.getLabel().equals(start)) {
				froniter.clear();
				explore.clear();
				current.setParent(null);
				started = true;
			}
			if (current.getLabel().equals(goal) && started==true)
				return current;
			else {
				explore.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					if (!froniter.contains(child) && !explore.contains(child)) {
						child.setParent(current);
						froniter.add(child);
					}
				}
			}
		}
		return null;
	}

	class NodeComparatorByHn implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();
			int result = h1.compareTo(h2);
			if (result == 0) {
				result = o1.getLabel().compareTo(o2.getLabel());
			}
			return result;
		}

	}

	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		return false;
	}
}
