package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
//	private List<Node> children = new ArrayList<Node>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> re = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			int threadHold = (data.get(i)%2)==0?data.get(i)/2-1:data.get(i)/2;
			for (int j = 1; j <= threadHold; j++) {
				Node node = new Node();
				node.add(j);
				node.add(data.get(i)-j);
				for (int k = 0; k < data.size(); k++) {
					if(k != i) {
						node.add(data.get(k));
					}
				}
				if(!re.contains(node)) {
					re.add(node);
				}
			}
		}
		return re;
	}

	

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		data.sort(DESCOMPARATOR);
		return data.get(0)<=2;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Node))
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	
	
}
