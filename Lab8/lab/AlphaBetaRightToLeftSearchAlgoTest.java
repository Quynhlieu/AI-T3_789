package lab;

public class AlphaBetaRightToLeftSearchAlgoTest {
	public static void main(String[] args) {
		Node nodeA = new Node("A");Node nodeB = new Node("B");
		Node nodeC = new Node("C");Node nodeD = new Node("D");
		Node nodeE = new Node("E");Node nodeF = new Node("F");
		Node nodeG = new Node("G");Node nodeH = new Node("H");
		Node nodeI = new Node("I");Node nodeJ = new Node("J");
		Node nodeK = new Node("K");Node nodeL = new Node("L");
		Node nodeM = new Node("M");Node nodeN = new Node("N");
		Node nodeO = new Node("O");Node nodeP = new Node("P");
		Node nodeQ = new Node("Q");Node nodeR = new Node("R");
		Node nodeS = new Node("S");Node nodeT = new Node("T");
		Node nodeU = new Node("U");Node nodeV = new Node("V");
		Node nodeW = new Node("W");Node nodeX = new Node("X");
		
		// Add children
		nodeA.addChild(nodeB);nodeA.addChild(nodeC);nodeA.addChild(nodeD);nodeA.addChild(nodeE);
		nodeB.addChild(nodeF);nodeB.addChild(nodeG);
		nodeF.addChild(nodeN);nodeF.addChild(nodeO);
		nodeO.addChild(nodeW);nodeO.addChild(nodeX);
		nodeC.addChild(nodeH);nodeC.addChild(nodeI);nodeC.addChild(nodeJ);
		nodeJ.addChild(nodeP);nodeJ.addChild(nodeQ);nodeJ.addChild(nodeR);
		nodeE.addChild(nodeK);nodeE.addChild(nodeL);nodeE.addChild(nodeM);
		nodeK.addChild(nodeS);nodeK.addChild(nodeT);
		nodeM.addChild(nodeU);nodeM.addChild(nodeV);
		
		// Set value 
		nodeG.setValue(-5);nodeN.setValue(4);
		nodeW.setValue(-3);nodeX.setValue(-5);
		nodeH.setValue(3);nodeI.setValue(8);
		nodeP.setValue(9);nodeQ.setValue(-6);
		nodeR.setValue(0);nodeD.setValue(0);
		nodeL.setValue(2);nodeS.setValue(3);
		nodeT.setValue(5);nodeU.setValue(-7);
		nodeV.setValue(-9);
		
		// Task 3
		AlphaBetaRightToLeftSearchAlgo rightToLeft = new AlphaBetaRightToLeftSearchAlgo();
		rightToLeft.execute(nodeA);
		System.out.println();
		
		// Task 2
		AlphaBetaSearchAlgo leftToRight = new AlphaBetaSearchAlgo();
		leftToRight.execute(nodeA);
		System.out.println();
		// Task 1 
		MiniMaxSearchAlgo m = new MiniMaxSearchAlgo();
		System.out.println("Max value: "+m.maxValue(nodeA));
		
		
	}
}
