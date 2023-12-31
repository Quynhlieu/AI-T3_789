package lab3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		
		//test
//		nodeG.addEdge(nodeE, 3);nodeA.addEdge(nodeB, 1);
//		nodeB.addEdge(nodeC, 1);
		
		UniformCostSearchAlgo a = new UniformCostSearchAlgo();
		//Task 4
//		System.out.println(NodeUtils.printPath(a.execute(nodeS, "G")));
		//Task5
//		System.out.println(NodeUtils.printPath(a.execute(nodeS, "S", "G")));
		
		DepthLimitedSearch b = new DepthLimitedSearch();
		//Task 6
		System.out.println(NodeUtils.printPath(b.execute(nodeS, "G", 3)));
	}
}
