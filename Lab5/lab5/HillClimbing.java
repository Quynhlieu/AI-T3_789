package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HillClimbing implements IPuzzleAlgo {
	// Tìm kiếm cục bộ local search (thuật toán leo đồi)
	// Không tìm thấy H tối ưu sẽ thêm danh sách node con vào frontier để tiếp tục duyệt
	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explore = new ArrayList<>();
		int count = 0;
		
		Node temp = model.getInitialState();
		temp.setH(model.computeH2(temp));
		frontier.add(temp);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			count++;
//			System.out.println("H=" + current.getH() + "\n" + current);
			if(current.equals(model.getGoalState())) {
				System.out.println(count);
				return current;
			}
			else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				int min = Integer.MAX_VALUE;
				for (Node child : children) {
					if (!frontier.contains(child) && !explore.contains(child) && child.getH() <= current.getH()) {
						frontier.add(child);
					}
				}
				if (frontier.isEmpty() ) {
					frontier.addAll(children);

				}
			}

		}
		System.out.println("Khong tim thay ");
		return null;
	}

}
