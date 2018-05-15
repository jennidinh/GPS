import java.util.Comparator;

public class DistComparator implements Comparator<Node>{
	public int compare(Node a, Node b) {
		int dist1 = a.getCost();
		int dist2 = b.getCost();
		
		return dist1 - dist2;
	}
	
}
