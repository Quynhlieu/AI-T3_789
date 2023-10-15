package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<Node> printPath(Node node) {
		if (node != null) {
			List<Node> result = new ArrayList<Node>();
			result.add(node);
			Node tmp;
			while ((tmp = node.getParent()) != null) {

				result.add(tmp);
				node = tmp;
			}
			Collections.reverse(result);
//			System.out.println(result);;
			return result;
		} else
			System.out.println("Khong tim thay");
			return new ArrayList<Node>();
	}
	
}
