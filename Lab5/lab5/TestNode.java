package lab5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("Lab5/lab5/PuzzleMap.txt", "Lab5/lab5/PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println("so sánh: "+initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
		System.out.println("H: "+initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
//
//		System.out.println(re);
//		System.out.println(re.getH());
		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));
//		System.out.println(p.);
		// System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		//
		// List<Node> children = p.getSuccessors(initialState);
		// System.out.println("Size: "+children.size());
		// for (Node child : children) {
		// System.out.println(child.getH()+" "+p.computeH(child) );
		// }
		
		
		// Task2
		GreedyBestFirstSearch greedy = new GreedyBestFirstSearch();
		long startTimeGreedy = System.currentTimeMillis();
		Node greedyResult = greedy.execute(p);
		long endTimeGreedy = System.currentTimeMillis();
		System.out.println("Thời gian chạy Greedy: "+(endTimeGreedy-startTimeGreedy)+"ms");
		System.out.println(greedyResult);
		
//		// Task3
		AStarSearch aStar = new AStarSearch();
		long startTimeAStar = System.currentTimeMillis();
		Node aStarResult = aStar.execute(p);
		long endTimeAStar = System.currentTimeMillis();
		System.out.println("Thời gian chạy A*: "+(endTimeAStar-startTimeAStar)+"ms");
		System.out.println(aStarResult);
		
		// Task 4
		BFS bfs = new BFS();
		long startTimeBFS = System.currentTimeMillis();
		Node bfsResult = bfs.execute(p);
		long endTimeBFS = System.currentTimeMillis();
		System.out.println("Thời gian chạy BFS: "+(endTimeBFS-startTimeBFS)+"ms");
		System.out.println(bfsResult);
		
		DFS dfs = new DFS();// giới hạn độ sâu là 5, nếu độ sâu quá 5 sẽ không tiếp tục duyệt cái hướng đi
		long startTimeDFS = System.currentTimeMillis();
		Node dfsResult = dfs.execute(p);
		long endTimeDFS = System.currentTimeMillis();
		System.out.println("Thời gian chạy DFS: "+(endTimeDFS-startTimeDFS)+"ms");
		System.out.println(dfsResult);
		
		HillClimbing local = new HillClimbing();
		long startTimeHillClimbing = System.currentTimeMillis();
		Node localResult = local.execute(p);
		long endTimeHillClimbing = System.currentTimeMillis();
		System.out.println("Thời gian chạy Hill Climbing: "+(endTimeHillClimbing-startTimeHillClimbing)+"ms");
		System.out.println(localResult);
		
		/**
		 * Nhận xét: 
		 * Greedy best-first search: thời gian chạy ngắn hơn BFS, DFS nhưng không tối ưu bằng A*.
		 * A*: thời gian chạy ngắn nhưng bước chạy lại nhiều hơn Greedy best-first.
		 * BFS và DFS là tìm kiếm mù, không dựa trên các yếu tố bài toán nên thời gian chạy lâu, bước chạy nhiều, tiêu hao tài nguyên.
		 * Nếu DFS được điều chỉnh giới hạn độ sâu thì thời gian và bước chạy được cải thiện hơn.
		 * Hill Climbing: Dễ rơi vào trường hợp tối ưu cục bộ nhưng tìm thời gian ngắn, bước chạy ít.
		 * Nếu Hill Climbing rơi vào tối ưu cục bộ có thể khắc phục bằng cách cho hàng xóm vào danh sách chờ để tiếp tục thực hiện bài toán.
		 * **/

	}
}
