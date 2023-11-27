package lab;

import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo{

	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("Alpha beta right to left search algo: "+v);
		
	}
	public int maxValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		int v = Integer.MIN_VALUE;
		List<Node> children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
		Collections.reverse(children);
		for (Node child : children) {
			v = Math.max(v, minValue(child, alpha, beta));
			if(v >= beta) {
				for (int i = children.indexOf(child)+1; i < children.size(); ++i) {
					printPrunedNode(children.get(i));
				}
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}
	public int minValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		int v = Integer.MAX_VALUE;
		List<Node> children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
		Collections.reverse(children);
		for (Node child : children) {
			v = Math.min(v, maxValue(child, alpha, beta));
			if(v <= alpha) {
				
				for (int i = children.indexOf(child)+1; i < children.size(); ++i) {
					printPrunedNode(children.get(i));
				}
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
	private void printPrunedNode(Node node) {
		System.out.println("Pruned node: "+node.getLabel());
		if(node.isTerminal()) {	
			return ;
		}
		List<Node> children = node.getChildren();
		for (Node child : children) {
			printPrunedNode(child);
		}
	}
}
