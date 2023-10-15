package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
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
		Stack<Node> froniter = new Stack<>();
		List<Node> exployed = new ArrayList<>();
		froniter.add(root);
		
		if(limit == 0) return null;
		
		while(!froniter.isEmpty()) {
			Node current = froniter.pop();
//			System.out.println(current.getLabel()+" "+current.getDepth());
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				exployed.add(current);
				if(current.getDepth() < limit) {
					List<Node> children = current.getChildrenNodes();
					Collections.reverse(children);
					for (Node child : children) {
						if(!froniter.contains(child) && !exployed.contains(child)) {
							froniter.add(child);
							child.setParent(current);
							child.setDepth(current.getDepth()+1);
							System.out.println(froniter);
						}
					}
				}
			}
			
		}
		return null;
	}
	
}
