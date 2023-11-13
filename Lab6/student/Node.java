package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j< N; j++) {
				if (state[i].isConflict(state[j]) && i!=j) {
//					System.out.println("("+i+";"+j+")");
					heuristic++;// Queen i so voi Queen j
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < state.length; i++) {
			Node newNode = new Node(state);
			newNode.state[i].move();
			result.add(newNode);
			
		}

		return result;
	}

	public Node selectNextRandomCandidate() {
		Random r = new Random();
		int q = r.nextInt(N);
		int row = r.nextInt(N);
		Node n = new Node(state);
		n.state[q].setRow(row);
		return n;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
//			System.out.println(state[i].getRow() +"; "+state[i].getColumn());
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	public Node getBestNode() {
		int min = Integer.MAX_VALUE;
		Node result = null;
		List<Node> children = generateAllCandidates();
//		System.out.println("DS; ");
		for (int i = 0; i < state.length; i++) {
//			System.out.print("("+children.get(i).getH()+"; ");
			if (children.get(i).getH() < min) {
				min = children.get(i).getH();
				result = children.get(i);
			}
		}

		return result;
	}
}
