package student;

public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();
		System.out.println(node.getH());
		
		System.out.println();
		HillClimbing hillClimbing = new HillClimbing();
		Node test = hillClimbing.execute(node);
		test.displayBoard();
		System.out.println(test.getH());
		
		 Node a = hillClimbing.executeHillClimbingWithRandomRestart(node);
		 a.displayBoard();
		 System.out.println("Step Climbed: "+hillClimbing.stepClimbed);
		 System.out.println("Random Restarts: "+hillClimbing.randomRestarts);
		 System.out.println("step Climbed After Random Restart: "+(hillClimbing.stepClimbedAfterRandomRestart));
		 
		 SimulatedAnnealingSearch simulatedAnnealingSearch = new SimulatedAnnealingSearch();
		 Node s = simulatedAnnealingSearch.execute(node);
		 s.displayBoard();
		 System.out.println(s.getH());
	}
}
