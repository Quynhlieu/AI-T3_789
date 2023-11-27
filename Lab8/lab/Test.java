package lab;

public class Test {
	public static void main(String[] args) {
		MiniMaxSearchAlgo m = new MiniMaxSearchAlgo();
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		Node nodeM = new Node("M");

		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeD);
		nodeB.addChild(nodeE);nodeE.setValue(3);
		nodeB.addChild(nodeF);nodeF.setValue(12);
		nodeB.addChild(nodeG);nodeG.setValue(8);
		nodeC.addChild(nodeH);nodeH.setValue(2);
		nodeC.addChild(nodeI);nodeI.setValue(4);
		nodeC.addChild(nodeJ);nodeJ.setValue(6);
		nodeD.addChild(nodeK);nodeK.setValue(14);
		nodeD.addChild(nodeL);nodeL.setValue(5);
		nodeD.addChild(nodeM);nodeM.setValue(2);
		
		// Task1
		m.execute(nodeA);
		
		// Task2
		AlphaBetaSearchAlgo a = new AlphaBetaSearchAlgo();
		a.execute(nodeA);System.out.println();
		a.execute(nodeB);System.out.println();
		a.execute(nodeC);System.out.println();
		a.execute(nodeD);System.out.println();
		
		// Task3
		AlphaBetaRightToLeftSearchAlgo r = new AlphaBetaRightToLeftSearchAlgo();
		r.execute(nodeA);System.out.println();
		
		
		
	}
}
