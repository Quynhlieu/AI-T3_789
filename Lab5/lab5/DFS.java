package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DFS implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		Stack<Node> frontier = new Stack();
		List<Node> explore = new ArrayList<>();
		int count = 0;
		int lever = 0;// Nếu lever lớn hơn 5 không tiếp tục xét node con
		
		frontier.add(model.getInitialState());
		
		first: while(!frontier.isEmpty()) {
			count++;
			Node current = frontier.pop();
			if(current.equals(model.getGoalState())) {
				System.out.println(count);
				return current;
			}
			else if(lever<=5){
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (int i = children.size()-1; i >= 0; i--) {
					if(!frontier.contains(children.get(i)) && !explore.contains(children.get(i))) {
						frontier.add(children.get(i));
					}
				}
			}else {
				lever=0;
				continue first;
			}
			lever++;
		}
		return null;
	}

}
