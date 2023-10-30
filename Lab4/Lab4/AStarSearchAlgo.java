package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> froniter = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> explore = new ArrayList<>();
		froniter.add(root);
		while(!froniter.isEmpty()) {
			Node current = froniter.poll();
			if(current.getLabel().equals(goal)) return current;
			else {
				explore.add(current);
				List<Edge> children = current.getChildren();
				for (Edge edge : children) {
					Node child = edge.getEnd();
					double newCode = current.getG() + edge.getWeight();
					if(!froniter.contains(child) && !explore.contains(child)) {
						child.setParent(current);
						child.setG(newCode);
						froniter.add(child);
					}else if(froniter.contains(child) && newCode < child.getG()){
						froniter.remove(child);
						child.setG(newCode);
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
		while(!froniter.isEmpty()) {
			Node current = froniter.poll();
			if(current.getLabel().equals(start)) {
				froniter.clear();
				explore.clear();
				current.setParent(null);
				current.setG(0);
				started = true;
			}
			if(current.getLabel().equals(goal) && started==true) return current;
			else {
				explore.add(current);
				List<Edge> children = current.getChildren();
				for (Edge edge : children) {
					Node child = edge.getEnd();
					double newCode = current.getG() + edge.getWeight();
					if(!froniter.contains(child) && !explore.contains(child)) {
						child.setParent(current);
						child.setG(newCode);
						froniter.add(child);
					}else if(froniter.contains(child) && newCode < child.getG()){
						froniter.remove(child);
						child.setG(newCode);
						child.setParent(current);
						froniter.add(child);
					}
				}
			}
		}
		return null;
	}
	class NodeComparatorByHn implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			Double f1 = o1.getG() + o1.getH();
			Double f2 = o2.getG() + o2.getH();
			int result = f1.compareTo(f2);
			if(result == 0) {
				result = o1.getLabel().compareTo(o2.getLabel());
			}
			return result;
		}
	}
	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		List<Node> explored = new ArrayList<Node>();
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (!current.getLabel().equals(goal)) {
				explored.add(current);
				Node g = execute(current, goal);
				// nếu như g != null và h(n) > pathcost từ current đến goal (tức là G) thì k admissible
				if (g != null && current.getH() > g.getG()) {
					System.out.println(current.getLabel() + ", H: " + current.getH() + ", G: " + g.getG());
					return false;
				}
				List<Edge> children = current.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Node child = children.get(i).getEnd();
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setG(0);
					}
				}

			}

		}
		return true;
	}
}
