package lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		node.setValue(v);
		System.out.println("Alpha beta left to right search algo: "+v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v
	// max: alpha >= beta
	
	public int maxValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		int v = Integer.MIN_VALUE;
		List<Node> children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
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
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v
	// min: beta <= alpha
	public int minValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		int v = Integer.MAX_VALUE;
		List<Node> children = node.getChildren();
		Collections.sort(children, Node.LabelComparator);
		for (Node child : children) {
			v = Math.min(v, maxValue(child, alpha, beta));
			if(v <= alpha) {
				// Print proned node
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
